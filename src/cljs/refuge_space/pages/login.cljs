(ns refuge-space.pages.login
    (:require [reagent.core :as reagent]))

(defn login-page []
  [:div [:h2 "login page"]
   [:div [:a {:href "#/about"} "go to about page"]]])
