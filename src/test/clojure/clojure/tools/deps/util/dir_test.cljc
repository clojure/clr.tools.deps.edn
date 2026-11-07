;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.deps.util.dir-test
  (:require
    [clojure.tools.deps.util.dir :as dir]
    [clojure.test :refer [deftest is are]])               ;;; DM: Added 'are'
  (:import
    #?(:clj [java.io File]
	   :cljr [System.IO FileInfo DirectoryInfo Path])))
	   

#?(
:clj
(deftest test-canonicalize
  (let [base (.getCanonicalFile (File. "."))]
    (binding [dir/*the-dir* base]
      (let [abs (File. "/a/b")]
        (is (= abs (dir/canonicalize abs)))
        (is (= (File. base "xyz") (dir/canonicalize (File. "xyz"))))))))
		
:cljr
(deftest test-canonicalize
  (let [base (DirectoryInfo. ".")]
    (binding [dir/*the-dir* base]
      (let [abs "/a/b"]
        (is (= (.FullName (FileInfo. abs)) (.FullName (dir/canonicalize abs))))
        (is (= (.FullName (FileInfo. (Path/Combine (.FullName base) "xyz"))) (.FullName (dir/canonicalize "xyz")))))
	  (let [abs "/a/b/"]
        (is (= (dir/trim-ending-directory-separator (.FullName (FileInfo. abs))) (.FullName (dir/canonicalize abs))))
        (is (= false (dir/directory-separator-char? (last (.FullName (dir/canonicalize abs))))))
        (is (= false (dir/directory-separator-char? (last (.FullName (dir/canonicalize "xyz")))))))
	  (is (= (.FullName (dir/canonicalize "xyz")) (.FullName (dir/canonicalize "xyz/"))))
	  (is (= (.FullName (dir/canonicalize "b//")) (.FullName (dir/canonicalize "b/"))))
	  (is (= true (dir/directory-separator-char? (last (.FullName (dir/canonicalize "/")))))))))
	  
		
)
		


#?( 

:cljr

(deftest test-subpath
  (are [p v] (= v (dir/sub-path? (System.IO.FileInfo. p)))
     "." true
	 "src" true
	 ".." false
	 (Path/GetTempPath) false
	 "./src/../." true))
	 
)

#?(
:cljr

(deftest test-with-dir
  (is (dir/with-dir "src" (instance? DirectoryInfo dir/*the-dir*))))
  
)