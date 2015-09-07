(ns refuge-space.pages.admin
    (:require [reagent.core :as reagent]))

(defn admin-page []
  [:div [:h2 "admin page"]
   [:div [:a {:href "#/about"} "go to about page"]]])
