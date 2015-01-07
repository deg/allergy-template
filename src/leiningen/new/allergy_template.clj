(ns leiningen.new.allergy-template
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "allergy-template"))

(defn allergy-template
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore" (render ".gitignore")]
             ["README.md" (render "README.md")]
             ["project.clj" (render "project.clj" data)]

             ["env/dev/cljs/{{sanitized}}/dev.cljs" (render "env/dev/cljs/dev.cljs" data)]
             ["env/prod/cljs/{{sanitized}}/prod.cljs" (render "env/prod/cljs/prod.cljs" data)]

             ["resources/index.html" (render "resources/index.html")]

             ["resources/public/css/json.human.css" (render "resources/public/css/json.human.css")]
             ["resources/public/css/style.css" (render "resources/public/css/style.css")]

             ["src/clj/{{sanitized}}/dev.clj" (render "src/clj/dev.clj" data)]
             ["src/clj/{{sanitized}}/server.clj" (render "src/clj/server.clj" data)]

             ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/core.cljs" data)]
             ["src/cljs/{{sanitized}}/reagent_helpers.cljs" (render "src/cljs/reagent_helpers.cljs" data)]
             ["src/cljs/{{sanitized}}/routes.cljs" (render "src/cljs/routes.cljs" data)]
             ["src/cljs/{{sanitized}}/session.cljs" (render "src/cljs/session.cljs" data)]

             ["src/cljs/{{sanitized}}/views/about_page.cljs" (render "src/cljs/views/about_page.cljs" data)]
             ["src/cljs/{{sanitized}}/views/app_page.cljs" (render "src/cljs/views/app_page.cljs" data)]
             ["src/cljs/{{sanitized}}/views/common.cljs" (render "src/cljs/views/common.cljs" data)]
             ["src/cljs/{{sanitized}}/views/dumper_page.cljs" (render "src/cljs/views/dumper_page.cljs" data)]
             ["src/cljs/{{sanitized}}/views/home_page.cljs" (render "src/cljs/views/home_page.cljs" data)]
             ["src/cljs/{{sanitized}}/views/new_page.cljs" (render "src/cljs/views/new_page.cljs" data)]
             ["src/cljs/{{sanitized}}/views/pages.cljs" (render "src/cljs/views/pages.cljs" data)]
             ["src/cljs/{{sanitized}}/views/user_page.cljs" (render "src/cljs/views/user_page.cljs" data)])))
