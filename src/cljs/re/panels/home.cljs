(ns re.panels.home
  (:require [re-frame.core :as re-frame]
            [re.layouts.main :as main-layout]
            [re.components.post :as post]))

(defn main
  []
  (let [subreddit (re-frame/subscribe [:subreddit])]
    [main-layout/main
     [post/main {:title "Took this pic a few weeks ago and can't stop looking at it. Still loving the ND life."
                 :url "https://i.redd.it/o81mufu60ahy.jpg"
                 :thumb-url "https://i.redditmedia.com/oy0JM0_y_CQtop8NCoGcZ8AXAaPLKTAJ3vRmETaRZE4.jpg?w=1024&s=3deed8877f838b1b7c4595f90994d05d"
                 :num-comments 17
                 :time-ago "6m"}]]))
