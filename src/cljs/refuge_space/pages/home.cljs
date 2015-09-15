(ns refuge-space.pages.home
    (:require [reagent.core :as reagent]
              [refuge-space.components.signup :refer [signup-widget]]))

(defn home-page []
  [:div
    [:div.row
      [:div.col-md-4.col-md-offset-2 [:img.img-thumbnail.logo {:src "images/logo.png"}]]
      [:div.col-md-3.tagline
        [:h1 [:b "You can help refugee families"]]
        [:h1 "By donating a place to stayhere in the UK"]]]
    [:div.row.pane
      [:div.col-md-4.col-md-offset-2.info-text
        [:h2 "We're connecting people who have" [:b " space in their homes "] "to " [:b "charities who are helping"] " refugees fleeing from war-torn countries"]
        [:span]
        [:p {:style {:textAlign "justify"}} "￼￼￼￼￼￼Hundreds of thousands of people have been displaced and are travelling across Europe in the hope of a safe place to live.
        Governments are doing what they deem appropriate but people are taking matters into their own hands – opening up their homes to
        people forced to leave theirs."]
        [:span]
        [:div.col-md-offset-2
          [:h1 {:style {:textAlign "right"}} "Sign up to register your offer of help"]]]
      [:div.col-md-3
        [signup-widget]]]])
