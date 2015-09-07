(ns refuge-space.router
    (:require [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [refuge-space.pages.home :refer [home-page]]
              [refuge-space.pages.admin :refer [admin-page]]
              [refuge-space.pages.about :refer [about-page]])
    (:import goog.History))

(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :nav-state "home")
  (session/put! :current-page #'home-page))

(secretary/defroute "/admin" []
  (session/put! :nav-state "admin")
  (session/put! :current-page #'admin-page))

(secretary/defroute "/about" []
  (session/put! :nav-state "about")
  (session/put! :current-page #'about-page))
