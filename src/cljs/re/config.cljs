(ns re.config)

;; debug switch
;; can be overridden by :closure-defines at compile time
(goog-define ^boolean dev? false)

(def version "v0a1")
