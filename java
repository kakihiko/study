Java


◆コンストラクタとメソッドの違い
・コンストラクタ…クラスと同じ名前
・メソッド…クラスとは違う名前



■アクセス修飾子
private:
同じクラス内でのみアクセス可能
パッケージアクセス:
同じパッケージ内でのみアクセス可能
public:
どこからでもアクセス可能
protected:
パッケージアクセスに加えて、違うパッケージでもサブクラスなら継承したスーパークラスのメンバにアクセス可能

なぜprivateにするのか。
　将来変数やメソッド名を変更可能にするため。疎密の観点で疎になり、独立性の高いプログラムになる。
  本来クラスを作るとは、カプセル化するため。
  
  
■パッケージのメリット
  パッケージが異なって入ればクラス名が同じでも大丈夫
  

■非 static フィールド number を static 参照できません
メインメソッドのあるクラスのフィールド変数をstaticにしないとメインメソッド内では使えない。
staticにしておくと、プログラムに呼び出された時にメモリに作成してくれるので、使える。

public class Exec {
	private  int number;
	public  void add() {
		number++;
	}
	public static void main(String[] args) {
		number = 200;
		add();
		System.out.println("number=" + number);
	}	

■ローカル変数とフィールド変数
変数	場所	メモリから消えるタイミング	
ローカル変数	メソッド内	メソッドが実行された直後
フィールド変数			消えない

■コンストラクタとnew
new演算子はコンストラクの名前からコピーするクラスを判断する。だから、コンストラクタの名前はクラスと同じにする。
内部の処理としてはnew演算子はすべてのインスタンスメンバをメモリにコピーしている。

■オーバーロード
クラスの中に同じ名前のメソッドを作ること。
サブクラスでスーパークラスと同じ名前のメソッドを作ることもオーバーロードになる。

public void add(){
number++
}

public void add(int val){
number += val;
}

■オーバーライド
スーパークラスから継承したメソッドを書き換える。
シグネチャー（メソッド名と引数構成）が同じで処理内容を変える。
ダイナミックパンディングにより、最後にオーバーライドしたメソッドが呼び出される。

■super()とは親クラスのメソッド、コンストラクタを使う
・super.showHand();
子クラスでオーバーライドした時でも、親クラスの元々のメソッドを使うことができる

・this.showHand();
子クラスでオーバーライドしたメソッドを使うことを明示的に示す。
Thisは省略しても構わない

・super();
スーパークラスのコンストラクタを使う



■メモリの各領域
領域／置かれるもの
コード領域／プログラム
スタック領域／変数
ヒープ領域／インスタンス

■nullは参照型
nullは参照先がないということ。参照型には代入できるが、intなどプリミティブ型には代入できない。

■equals と ==
equals は値そのものを比較
== は”参照”先を比較

■参照型とプリミティブ型
参照型は変数に参照値が入っていて、参照先に値がある
プリミティブ型は変数に値そのものが入っている



■listのソート
比較するキーを指定した並び替え
list.sort(<コンパレータ>);
list.sort(comp);
コンパレータはComparatorインタフェースを実装したクラスのインスタンス
public interface Comparator<T>{
 int compare(T o1, T o2);
}

比較したいインスタンスの型に合わせてComparatorインタフェースを実装したクラスを作る。
実装するときはcompareメソッドをオーバーライドする。
compareToメソッドは文字列の大小を数値で返す。
public class NameComparator implements Comparator<Member> {
public int compare(Member o1, Member o2){
String s1 = o1.getName(),
String o2 = o2.getName(),
return s1.compareTo(s2)
}
}


■ファクトリメソッド
クラスのインスタンスを返すメソッドのこと
LocalDate today = LocalDate.now();


■ポリモーフィズム（多態性）とはスーパークラスの機能をサブクラスによって変えること
スーパークラスのメソッド1をサブクラスでオーバーライドする。

スーパークラスA
メソッド1

サブクラスB
@override
メソッド1

サブクラスC
@override
メソッド1


■デフォルトメソッド
インタフェースに最初から実装されている具象メソッド（抽象メソッドではなく）
後からインタフェースにメソッドを追加した時に、元々そのインタフェースを利用していたクラスがエラーにならないようにするため。

追加前
クラスA implement インタフェースB

追加後
インタフェースB
Int メソッドB();

クラスA implement インタフェースB
←メソッドBをオーバーライドしないとコンパイルエラーになる。


■StringBuffer と StringBuilder の違い
String
↓
StringBuilder
↓
StringBuffer

StringBuilderは文字列を結合したりして新しくする時に、メモリの新しい領域を消費しない。
StringBufferはStringBuilderをマルチスレッドで実行するので、速い。


■thisをつける場合と付けない場合
メソッドの中で引数とフィールドで同じ名前の時に区別するために、thisをつける
Thisをつけた場合、フィールドを意味する


■Javaの括弧の役割

《{》 と 《}》 は、 クラス定義、メソッド定義、コンストラクタ定義、ブロックの始まりと終わりを示します。 つまり、Javaのプログラムの構造を決めるという非常に重要な役割を持ちます。
《(》 と 《)》 は、メソッドとコンストラクタの引数リストの始まりと終わり、 制御構造文の条件記述部分の始まりと終わり、 型キャストの始まりと終わり、 計算式の特定の範囲の始まりと終わりを示します。
《[》 と 《]》 は、配列のインデックスの始まりと終わりを示します。 また、型宣言の時に配列であることを示すためにも用いられます。



