(ns re.routes
  (:require [bidi.bidi :as bidi]
            [bidi.verbose :refer [branch param leaf]]
            [accountant.core :as accountant]
            [re-frame.core :as re-frame]))

(def routes
  ["/" {"" :home
        "r/" {""               :subreddits
              [:subreddit "/"] {""    :subreddit
                                [:id] :post}}}])

(def url-for (partial bidi/path-for routes))

(defn nav-handler
  [path]
  (let [match      (bidi/match-route routes path)
        panel-name (keyword (str (name (:handler match)) "-panel"))]
    (re-frame/dispatch [:set-active-panel panel-name])))

(defn path-exists?
  [path]
  (boolean (bidi/match-route routes path)))

(defn start
  []
  (accountant/configure-navigation! {:nav-handler nav-handler
                                     :path-exists? path-exists?}))
