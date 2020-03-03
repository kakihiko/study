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

■メモリの各領域
領域／置かれるもの
コード領域／プログラム
スタック領域／変数
ヒープ領域／インスタンス

■nullは参照型
nullは参照先がないということ。参照型には代入できるが、intなどプリミティブ型には代入できない。


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

