(ns re.config
  (:require [garden.color :as color]))

;; Debug switch
;; can be overridden by :closure-defines at compile time
(goog-define ^boolean dev? false)

;; App theme information.
(def theme {:background (color/hsl 0 0 100)
            :text       (color/hsl 0 0 0)})
