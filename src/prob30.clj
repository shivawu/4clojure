; 30. Compress a Sequence
(fn [s]
  (loop [c [] x s las nil]
    (if (empty? x) c
      (recur (if (= las (first x)) c (conj c (first x)))
        (rest x)
        (first x)))))

