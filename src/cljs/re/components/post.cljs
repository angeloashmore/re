(ns re.components.post
  (:require [clojure.string :as string]))

(defn thumb
  [src]
  [:a.db.pa3.flex-none.link {:href "/"}
   [:div.w2.h2.br2.cover {:style {:background-image (str "url(" src ")")}}]])

(defn detail
  [index text]
  [:li.list.mr2 {:key index}
   [:span.black-50.f7 text]])

(defn main
  [title]
  (let [src     "https://i.redd.it/o81mufu60ahy.jpg"
        details ["6c" "5h" "imgur"]]
    [:div.flex.align-start
     [thumb src]
     [:div.flex-auto.mv3.mr3
      [:h2.lh-title.ma0.mb1.normal.f5 (string/lower-case title)]
      [:ul.ma0.pa0.flex (map-indexed detail details)]]]))
