# clojure-private-test

This project shows how to test private functions in Clojure.

# Description

The code in `core.clj` has two functions in the `demo.core` namespace

* `add` : A public  function
* `private-add` : A private function

The test code in the `core_test.clj` in a separate namespace `demo.core-test`

## Usage

From the terminal, run

```
lein test
```

## References

* Nurullah Akkaya [@nakkaya](https://twitter.com/nakkaya) blog post on [Unit Testing in Clojure](https://nakkaya.com/2009/11/18/unit-testing-in-clojure/)
* Christopher Maier [@_cwm_](https://twitter.com/_cwm_) blog post [Not So Private Clojure Functions](http://christophermaier.name/2011/04/30/not-so-private-clojure-functions/)