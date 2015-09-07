(ns refuge-space.pages.giver
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [refuge_space.local-storage :as ls]
              [matchbox.core :as m]
              [reagent-forms.core :refer [bind-fields]]))

(def doc (atom {}))
(def fb_root (m/connect "https://confide.firebaseio.com/"))

(defn twitter-callback [err auth]
   (when err (js/console.log "Login Failed!" err))
   (prn (aget auth "twitter" "displayName")))

(defn twitter-login []
  (.authWithOAuthPopup fb_root "twitter" twitter-callback))

(defn get-name []
  (let [auth (JSON/parse (ls/get-item "firebase:session::confide"))]
    (if auth
      (reset! doc :user.name (aget auth "twitter" "displayName")))))

(defn form-template []
  (get-name)
  [:div.jumbotron
   [:h2 "Register your free space"]
   [:input {:field :text :id :user.name :placeholder "full name" :autoFocus "true"}]
   [:button {:on-click twitter-login} "login with twitter"]
   [:div [:a {:href "#/about"} "go to about page"]]])


(defn giver-page []
  [bind-fields form-template doc])
