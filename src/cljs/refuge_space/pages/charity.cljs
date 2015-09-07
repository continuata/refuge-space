(ns refuge-space.pages.charity
    (:require [reagent.core :as reagent]))

(defn charity-page []
  [:div [:h2 "charity page"]
   [:div [:a {:href "#/about"} "go to about page"]]])
