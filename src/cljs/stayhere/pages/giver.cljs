(ns stayhere.pages.giver
    (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [stayhere.local-storage :as ls]
              [matchbox.core :as m]
              [cognitect.transit :as t]
              [reagent-forms.core :refer [bind-fields]]))

(def doc (atom {}))
(def fb_root (m/connect "https://confide.firebaseio.com/"))
(def r (t/reader :json))

(defn auth-callback [err]
   (when err (js/console.log "Login Failed!" err)))

(defn twitter-login []
  (.authWithOAuthPopup fb_root "twitter" auth-callback))

(defn facebook-login []
  (.authWithOAuthPopup fb_root "facebook" auth-callback))

(defn get-auth []
  (t/read r (ls/get-item "firebase:session::confide")))

(defn show-login []
  [:div
    [:button {:on-click twitter-login} "login with twitter"]
    [:button {:on-click facebook-login} "login with facebook"]])

(defn from-postcode []
  ; https://api.getAddress.io/v2/uk
  (prn (:user.postcode @doc)))

(defn form-template []
  (let [auth (get-auth)
        address (from-postcode)]
    [:div.jumbotron
      (if auth
        [:form.form-horizontal
          [:h2 "Register your free space"]
          [:div.control-group
            [:label.control-label {:for :user.name} "Name:"]
            [:div.controls
              [:input {:field :text
                       :id :user.name
                       :placeholder "full name" :autoFocus "true"}]]]
          [:div.control-group
            [:label.control-label {:for :user.email} "Email:"]
            [:div.controls
              [:input {:field :email :id :user.email :placeholder "email address"}]]]
          [:div.control-group
            [:label.control-label {:for :user.postcode} "Postcode:"]
            [:div.controls
              [:input {:field :text :id :user.email :placeholder "postcode"}]]]]
      (show-login))]))


(defn giver-page []
  [bind-fields form-template doc])
