(ns re.components.post
  (:require [clojure.string :as string]
            [lambdaisland.uri :refer [uri]]
            [re.routes :as routes]))

(defn thumb
  [src url]
  [:a.db.pa3.flex-none.link {:href url}
   [:div.w2.h2.br2.cover {:style {:background-image (str "url(" src ")")}}]])

(defn detail
  [index text]
  [:li.list.mr2 {:key index}
   [:span.black-50.f7 text]])

(defn main
  [{:keys [title url thumb-url num-comments time-ago]}]
  (let [host (-> url uri :host)]
    [:div.flex.align-start
     [thumb thumb-url url]
     [:a.link.flex-auto.black
      {:href (routes/url-for :post :subreddit "Miata" :id "5ve7f1")}
      [:div.mv3.mr3
       [:h2.lh-title.ma0.mb1.normal.f5 (string/lower-case title)]
       [:ul.ma0.pa0.flex
        (map-indexed detail [(str num-comments "c") time-ago host])]]]]))
