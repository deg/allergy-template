(ns leiningen.new.allergy-template
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "allergy-template"))

(defn allergy-template
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
["env/prod/cljs/{{sanitized}}/prod.cljs" (render "prod.cljs" data)]
["src/cljs/{{sanitized}}/reagent_helpers.cljs" (render "reagent_helpers.cljs" data)]
["project.clj" (render "project.clj" data)]
["env/dev/cljs/{{sanitized}}/dev.cljs" (render "dev.cljs" data)]
["src/cljs/{{sanitized}}/session.cljs" (render "session.cljs" data)]
["src/cljs/{{sanitized}}/views/new_page.cljs" (render "new_page.cljs" data)]
["src/cljs/{{sanitized}}/views/app_page.cljs" (render "app_page.cljs" data)]
["src/cljs/{{sanitized}}/views/home_page.cljs" (render "home_page.cljs" data)]
["src/cljs/{{sanitized}}/views/common.cljs" (render "common.cljs" data)]
["src/cljs/{{sanitized}}/views/dumper_page.cljs" (render "dumper_page.cljs" data)]
["src/cljs/{{sanitized}}/routes.cljs" (render "routes.cljs" data)]
["src/cljs/{{sanitized}}/views/pages.cljs" (render "pages.cljs" data)]
["src/clj/{{sanitized}}/dev.clj" (render "dev.clj" data)]
["src/clj/{{sanitized}}/server.clj" (render "server.clj" data)]
["src/cljs/{{sanitized}}/views/user_page.cljs" (render "user_page.cljs" data)]
["src/cljs/{{sanitized}}/views/about_page.cljs" (render "about_page.cljs" data)]
["resources/public/css/json.human.css" (render "json.human.css")]
["README.md" (render "README.md")]
[".gitignore" (render ".gitignore")]
["resources/index.html" (render "index.html")]
["resources/public/css/style.css" (render "style.css")]
)))