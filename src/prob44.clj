; 44. Rotate Sequence
(fn [n s]
  (let [l (count s)
        m (mod (+ l (mod n l)) l)]
    (concat (drop m s) (take m s))))

