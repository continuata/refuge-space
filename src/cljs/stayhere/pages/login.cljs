(ns stayhere.pages.login
  (:require [reagent.core :refer [atom]]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [matchbox.core :as m]
            [reagent-forms.core :refer [bind-fields]]))

(def fb_root (m/connect "https://confide.firebaseio.com/"))

(def doc (atom {}))

(defn load-registrations [user]
  (session/put! :user user)
  (init-store user)
  (secretary/dispatch! "#/"))

(defn login-callback [error res]
  (if error
    (prn error)
    (load-registrations res)))

(defn login []
  (let [user (:user @doc)]
    (m/auth fb_root (:email user) (:password user) login-callback)
    (reset! doc)))

(def form-template
  [:div.login
    [:div.login-box
        [:div.login-field
            [:span.glyphicon.glyphicon-envelope]
            [:input {:field :email :id :user.email :placeholder "email address" :autoFocus "true" :autoComplete "on"}]
            [:div.login-underline]]
        [:div.login-field
            [:span.glyphicon.glyphicon-lock]
            [:input {:field :password :id :user.password :placeholder "password" :autoComplete "on"}]
            [:div.login-underline]]
        [:div.login-checkbox
            [:input {:field :checkbox :id :user.remember}] "Remember Me"]
        [:button.login-button {:on-click login} "LOG IN"]]
    [:div.login-line-left]
    [:div.login-line-right]])

(defn login-page []
  [bind-fields form-template doc])
