clr.tools.deps.edn
========================================

A port to ClojureCLR of the [`tools.deps.edn`](https://github.com/clojure/tools.deps.edn) library.

From that repository's README:

> Rationale:
>
> This is a small library for reading and manipulating deps.edn files and data structures.
> It can be used in scenarios where the full [tools.deps](https://github.com/clojure/tools.deps)
> library is not needed for dep expansion (which pulls in many large libraries).

* [deps.edn Reference](https://clojure.org/reference/deps_edn)

Note that the `tools.deps` library has been ported for ClojureCLR; it can be found at [`clr.tools.deps`](https://github.com/clojure/clr.tools.deps).

# Release Information

Latest release: 0.9.49


[deps.edn](https://clojure.org/reference/deps_edn) dependency information:

```
io.github.clojure/clr.tools.deps.edn {:git/tag "v0.9.49" :git/sha "ba20910"}
```


NuGet dependency information:


```
Install-Package clojure.tools.deps.edn  -Version 0.9.49
```

# Copyright and License

The original source this is ported from carries this copyright.

> Copyright © Rich Hickey, Alex Miller, and contributors

The modified code herein is also

> Copyright © Rich Hickey, Alex Miller, and contributors

All rights reserved. The use and
distribution terms for this software are covered by the
[Eclipse Public License 1.0] which can be found in the file
LICENSE at the root of this distribution. By using this software
in any fashion, you are agreeing to be bound by the terms of this
license. You must not remove this notice, or any other, from this
software.

[Eclipse Public License 1.0]: https://opensource.org/license/epl-1-0/
