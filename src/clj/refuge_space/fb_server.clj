(ns refuge-space.fb-server
  (:require [matchbox.core :as m]))

(def fb-key (System/getenv "firebase_confide_key"))

(defn run []
  (prn (str "running firebase with key " fb-key)))
