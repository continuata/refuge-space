(ns stayhere.components.signup
  (:require [reagent.core :refer [atom]]
            [reagent.session :as session]))

(defn active? [state val]
  (if (= state val) "active" ""))

(defn page-1 []
  [:div "page 1"])

(defn page-2 []
  [:div "page 2"])

(defn page-3 []
  [:div "page 3"])

(defn current-page []
  (case (session/get :signup-page)
    "page-1" [page-1]
    "page-2" [page-2]
    "page-3" [page-3]))

(defn click [evt]
  (session/put! :signup-page (-> evt .-target .-attributes .-data .-value)))

(defn signup-widget []
  (session/put! :signup-page "page-1")
  (fn []
    (let [page-state (session/get :signup-page)]
      [:div.signup-widget
        [:div.signup-title "Sign up"]
        [:span.signup-arrow.glyphicon.glyphicon-triangle-bottom]
        [:div.signup-pane
          [current-page]]
        [:ol.signup-indicators
          [:li {:class (active? page-state "page-1") :on-click click :data "page-1"}]
          [:li {:class (active? page-state "page-2") :on-click click :data "page-2"}]
          [:li {:class (active? page-state "page-3") :on-click click :data "page-3"}]]])))
