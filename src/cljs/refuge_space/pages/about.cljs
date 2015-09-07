(ns refuge-space.pages.about
    (:require [reagent.core :as reagent]))

(defn about-page []
  [:div [:h2 "About page"]
   [:div [:a {:href "#/"} "go to the home page"]]]) 
