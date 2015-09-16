(ns stayhere.components.carousel
    (:require [reagent.core :as reagent]
              [reagent.session :as session]))

(defn carousel []
  [:div.carousel.slide {:data-ride "carousel" :id "signup-pages"}
    [:ol.carousel-indicators
      [:li {:data-target "#signup-pages", :data-slide-to "0", :class "active"}]
      [:li {:data-target "#signup-pages", :data-slide-to "1"}]
      [:li {:data-target "#signup-pages", :data-slide-to "2"}]]
    [:div.carousel-inner {:role "listbox"}
      [:div.item {:class "active"} "PAGE 1"]
      [:div.item "PAGE 2"]
      [:div.item "PAGE 3"]
      [:a {:class "left carousel-control", :href "#signup-pages", :role "button", :data-slide "prev"}
        [:span.glyphicon.glyphicon-chevron-left {:aria-hidden "true"}]
        [:span.sr-only "Previous"] ]
      [:a {:class "right carousel-control", :href "#signup-pages", :role "button", :data-slide "next"}
        [:span.glyphicon.glyphicon-chevron-right {:aria-hidden "true"}]
        [:span.sr-only "Next"]]]])
