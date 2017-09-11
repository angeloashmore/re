(ns re.components.header
  (:require [clojure.string :as string]
            [re-frame.core :as re-frame]))

(defn logo
  []
  [:a.db.pa3.pr0.flex-none.link {:href "/"}
   [:h1.w2.h2.ma0.br2.bg-yellow.flex.items-center.justify-center
    [:span.black-50.f5.normal.lh-solid "re"]]])

(defn search
  []
  (let [subreddit     (re-frame/subscribe [:subreddit])
        resolve       #(if (string/blank? %) nil %)
        set-subreddit #(re-frame/dispatch [:set-subreddit (resolve %)])]
    [:input.input-reset.pa3.outline-0.bn.flex-auto.lh-solid.f5.black
     {:type            "text"
      :auto-capitalize "none"
      :auto-correct    "off"
      :value           @subreddit
      :on-change       #(set-subreddit (-> % .-target .-value))}]))

(defn main
  []
  [:header.bb.b--black-05
   [:div.mw8.center.flex
    [logo]
    [search]]])
