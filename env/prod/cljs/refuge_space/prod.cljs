(ns refuge-space.prod
  (:require [refuge-space.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
