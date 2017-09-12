(ns re.panels.home
  (:require [re-frame.core :as re-frame]
            [re.layouts.main :as main-layout]
            [re.components.post :as post]))

(defn main
  []
  (let [subreddit (re-frame/subscribe [:subreddit])]
    [main-layout/main
     [post/main "Took this pic a few weeks ago and can't stop looking at it. Still loving the ND life."]]))
