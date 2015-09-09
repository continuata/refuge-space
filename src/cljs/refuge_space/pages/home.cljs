(ns refuge-space.pages.home
    (:require [reagent.core :as reagent]
              [refuge-space.components.carousel :refer [carousel]]))

(defn home-page []
  [:div.row
    [:div.col-md-3.col-md-offset-3 [:img.img-thumbnail {:src "images/logo.png"}]]
    [:div.col-md-3 [:h1 "Sharing our homes with refugees"]]])
