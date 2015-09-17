(ns stayhere.components.signup
  (:require [reagent.core :refer [atom]]
            [reagent.session :as session]
            [matchbox.core :as m]))

(def fb_root (m/connect "https://confide.firebaseio.com/stayhere_queue/tasks"))

(defn active? [state val]
  (if (= state val) "active" ""))

(defn go-to [page]
  (session/put! :signup-page page))

(def volunteer (atom {}))

(defn submit []
  (m/conj! fb_root @volunteer))

(defn sync [evt]
  (let [id (-> evt .-target .-id)
        data (-> evt .-target .-value)]
    (swap! volunteer assoc id data)))

(defn input [type id label af]
  (let [val (get @volunteer id)]
    [:input {:field type :id id :placeholder label :autoFocus af :autoComplete "on" :on-change sync :value val}]))

(defn page-1 []
  [:div.signup-fields
    (input :text "name" "full name" "true")
    (input :email "email" "email address" "false")
    (input :postcode "postcode" "postcode" "false")
    [:button.next-button {:on-click #(go-to "2")} "next"]])

(defn page-2 []
  [:div.signup-fields
    [:button.next-button {:on-click #(go-to "3")} "next"]])

(defn page-3 []
  [:div.signup-fields
    [:button.next-button {:on-click submit} "submit"]])

(defn current-page []
  (case (session/get :signup-page)
    "1" [page-1]
    "2" [page-2]
    "3" [page-3]))

(defn click [evt]
  (session/put! :signup-page (-> evt .-target .-attributes .-data .-value)))

(defn signup-widget []
  (session/put! :signup-page "1")
  (fn []
    (let [page-state (session/get :signup-page)]
      [:div.signup-widget
        [:div.signup-title "Sign up"]
        [:span.signup-arrow.glyphicon.glyphicon-triangle-bottom]
        [:div.signup-pane
          [current-page]]
        [:ol.signup-indicators
          [:li {:class (active? page-state "1") :on-click click :data "1"}]
          [:li {:class (active? page-state "2") :on-click click :data "2"}]
          [:li {:class (active? page-state "3") :on-click click :data "3"}]]])))
