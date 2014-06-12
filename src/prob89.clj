; 89. Graph Tour
(fn [g]
  (let [degs (into {} (for [[k v] (group-by identity (flatten g))] [k (count v)]))
        nodes (keys degs)
        connected-comp (fn find-cc [c cc]
                         (let [nexts (for [[x y] g :when (= x c) :when (not (contains? cc y))] y)
                               ncc (into cc nexts)]
                           (if (empty? nexts)
                             cc
                             (reduce into ncc (map #(find-cc % ncc) nexts)))))
        connected (= (count (connected-comp (first nodes) #{(first nodes)})) (count nodes))
        odd-nodes (count (filter odd? (vals degs)))]
    (and connected (or (= 0 odd-nodes) (= 2 odd-nodes)))))

