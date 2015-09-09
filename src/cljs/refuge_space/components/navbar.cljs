(ns refuge-space.components.navbar
    (:require [reagent.core :as reagent]
              [reagent.session :as session]))

(defn active? [state val]
  (if (= state val) "active" ""))

(defn navbar [nav-state]
  [:nav {:class "navbar navbar-default navbar-fixed-top"}
    [:div {:class "navbar-header"}
      [:button {:type "button", :class "navbar-toggle collapsed", :data-toggle "collapse", :data-target ".navbar-collapse"}
        [:span {:class "sr-only"} "Toggle navigation"]
        [:span {:class "icon-bar"}] ]
          [:a {:class "navbar-brand", :href "#/"} "stayhere.org.uk"]]
    [:div {:class "navbar-collapse collapse"}
      [:ul {:class "nav navbar-nav"}
        [:li {:class (active? nav-state "home")} [:a {:href "#/"} "sign up"]]
        [:li {:class (active? nav-state "charity")} [:a {:href "#/charity"} "charity login"]]
        [:li {:class (active? nav-state "about")} [:a {:href "#/about"} "how it works"]]]]])
