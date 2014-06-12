; 78. Reimplement Trampoline
(fn trmpol
  ([f]
    (let [r (f)]
      (if (fn? r) (recur r) r)))
  ([f & args]
    (trmpol #(apply f args))))

