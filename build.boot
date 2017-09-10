(set-env!
  :source-paths   #{"src/cljs"}
  :resource-paths #{"resources"}
  :dependencies   '[[org.clojure/clojure         "1.8.0"]
                    [org.clojure/clojurescript   "1.9.908"]
                    [org.clojure/tools.nrepl     "0.2.13" :scope "test"]
                    [com.cemerick/piggieback     "0.2.2"  :scope "test"]
                    [weasel                      "0.7.0"  :scope "test"]
                    [adzerk/boot-cljs            "2.1.3"  :scope "test"]
                    [adzerk/boot-cljs-repl       "0.3.3"  :scope "test"]
                    [adzerk/boot-reload          "0.5.2"  :scope "test"]
                    [pandeiro/boot-http          "0.8.3"  :scope "test"]
                    [binaryage/devtools          "0.9.4"  :scope "test"]
                    [reagent                     "0.8.0-alpha1"]
                    [reagent-utils               "0.2.1"]
                    [re-frame                    "0.10.1"]
                    [day8.re-frame/async-flow-fx "0.0.8"]
                    [day8.re-frame/http-fx       "0.1.4"]
                    [bidi                        "2.1.2"]
                    [kibu/pushy                  "0.3.8"]])

(require
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
  '[adzerk.boot-reload    :refer [reload]]
  '[pandeiro.boot-http    :refer [serve]])

(deftask build
  "This task contains all the necessary steps to produce a build."
  []
  (comp (speak)
        (cljs)))

(deftask run
  "The `run` task wraps the building of your application in some useful tools
  for local development: an http server, a file watcher a ClojureScript REPL
  and a hot reloading mechanism"
  []
  (comp (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production
  []
  (task-options! cljs {:optimizations :advanced})
  identity)

(deftask development
  []
  (task-options! cljs {:optimizations :none
                       :closure-defines {'re.config/dev? true}
                       :source-map true}
                 reload {:on-jsload 're.app/init})
  identity)

(deftask dev
  "Simple alias to run application in development mode."
  []
  (comp (development)
        (run)))
