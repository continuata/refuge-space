(ns refuge-space.pages.home
    (:require [reagent.core :as reagent]))

(defn home-page []
  [:div [:h2 "Home page"]
   [:div [:a {:href "#/about"} "go to about page"]]])
