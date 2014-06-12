; 130. Tree reparenting
(fn [r tree]
  (let [dfs (fn self [t]
              (if (= r (first t))
                (with-meta (list t) {:found true})
                (let [children (map self (rest t))
                      groups (group-by #((meta %) :found) children)]
                  (if (groups true)
                    (with-meta
                      (cons
                        (cons (first t) (groups false))
                        (first (groups true)))
                      {:found true})
                    (with-meta t {:found false})))))]
    (reduce #(concat %2 (list %1)) (dfs tree))))

