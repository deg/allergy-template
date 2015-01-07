# Sample using reagent in a single-page-app

(TL;DR) This is a template for single-page ClojureScript apps, using
the Reagent interface library to Facebook React and a rich set of other
useful libraries.

Allergy is strongly based on Chestnut, but modified to work with
Reagent rather than Om. It also lifts some key bits lifted from the
reagent sample apps.

## The name

Why "allergy"?

I'm not thrilled about the name, but I wanted something that would tie
together "react" and "chestnut". Granted, chestnuts aren't peanuts,
and peanuts aren't even nuts, but with allergic reactions to peanuts
being so common, I figured this name kind of works.


## Getting started

See the [Chestnut](https://github.com/plexus/chestnut) readme and
documentation for general guidance. Note, though, that I built this
from the Chestnut template a few weeks ago (November 2014), so things
may have changed slightly.

In broad strokes, you need to first start a repl: from a terminal:
`lein repl`, or from Emacs: `M-x cider-jack-in`.

In the REPL do

```clojure
(run)
(browser-repl)
```

to kick things off.

To alter the page state from the repl, try

```
(ns allergy.core)
(swap! the-doc assoc-in [:user :last-name] "Johnson")
```

To deploy to Heroku (assuming you've already configured the Heroku
tools on your machine):

``` sh
git push heroku master:master
heroku open
```

Foreman

``` sh
lein with-profile -dev,+production uberjar && foreman start
```

## Background

This project began as my attempt to find a nice template for modern
(December 2014) ClojureScript projects. I began with no knowledge of
Bootstrap, React, Om, Reagent, Reagent-Forms, Figwheel, Weasel, or
Chestnut, and only marginal experience with cider or piggieback.

I found examples of many of these pieces, but no clear demomstration
of how to put all the pieces together.

My ground rules:
- I wanted to stay in an Emacs developement environment
- I wanted the repl/browser interaction to be a live and pain-free as possible
- I wanted deployment to Heroku or similar platforms to be easy and
  "just work". This is not an area where I wanted to dedicate much
  time to learning the tooling.
- My projects will run mostly on the client side, so I wanted a focus
  on ease of coding in clojurescript. At the same time, I know I'll
  occasionally need server-side code, so I wanted the framework to
  include at least a stub of the Clojure side
- React looks very cool. I wanted to give it a try
- Based on what I'd read, I expected to be personally more comfortable
  in reagent than in Om, at least for my first projects
- Bootstrap looked like a good CSS library to make my projects appear
  reasonably non-ugly, despite my lack of design skills

[Chestnut](https://github.com/plexus/chestnut) was a huge first
step. It already combines much of what I wanted. It plays well with
Emacs, support Heroku deployment, gives live repl/browser
interactions, includes Om/React, etc.  The only missing bit was
support for reagent.

I went through some teething pains getting reagent to work, due to my
lack of experience with it.

I don't remember all the steps; I'll try to clean up and document
soon. For now, take a look at the commit history of this project.

Challenges included, I think:
- Om and Reagent had different expectations of where to find css
  files.
- I had trouble integrating sample code to support dynamic fields
  (from the
  [forms-example](https://github.com/reagent-project/reagent-forms/tree/master/forms-example)
  code in
  [reagent-forms](https://github.com/reagent-project/reagent-forms))
  and single-page apps (from the
  [adding-a-page](https://github.com/reagent-project/reagent-cookbook/tree/master/recipes/adding-a-page)
  recipe in
  [reagent-cookbook](https://github.com/reagent-project/reagent-cookbook)). I
  didn't quite grasp what they were doing, nor how to get them to play
  together at first.
- I did not want to bring in any more support libraries just yet, so
  avoided using the full adding-a-page recipe, which wanted to bring
  in libraries like secretary and garden.
- I had some conceptual misunderstandings. (See
  [my questions](https://github.com/reagent-project/reagent-forms/issues/30)).


## To do

This is still very much a work in progress. Here are some things I
still need to do:

- Really understand what's going on with React, Reagent,
  Reagent-fields, and even Bootstrap. The sad truth is that I don't
  really understand any of the underlying details yet.
- Integrate a testing framework

## License

Copyright © 2014 Degel Sofware Ltd.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
