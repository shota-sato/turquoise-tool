# クイックソートアルゴリズム
配列をピボットを基準に分割します。<br>
ピボットより小さい要素は左側に、大きい要素は右側に移動します

## ピボット（pivot）とは
クイックソートアルゴリズムにおいて、配列を分割するために選択される基準となる要素のこと

## ピボットの選び方
最後の要素: 配列の最後の要素をピボットとして選ぶ。<br>
最初の要素: 配列の最初の要素をピボットとして選ぶ。<br>
中央値: 配列の中央値をピボットとして選ぶ<br>
（計算が複雑になることがありますが、バランスの良い分割が期待できます）。<br>

この実装では、配列の最後の要素（array[high]）がピボットとして選ばれています。
最大値や中央値ではありません。

