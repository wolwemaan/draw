test -z "$1" && echo usage $0 basename && exit
name="$1"

createnew () {
	dir="$1"
	input="$2"
	target="$3"
	codestr="s/$input/$target/g;"
	test ! -z "$4" && codestr="$codestr;s/$4/$5/g;"
	test ! -z "$6" && codestr="$codestr;s{$6}{$7}g;"
	cat "$dir/${input}.java" | perl -npe "$codestr" > "$dir/${target}.java"
}

basedir=./eclipse-workspace/kattis
testdatadir="./${name,,}/"
src=Akcija
idir="./${src,,}/"

#createnew $basedir/src/ Morning "$name"
#createnew $basedir/test/ MorningTest "${name}Test" "Morning.main" "${name}.main" "./morning/" "$testdatadir"
createnew $basedir/src/ $src "$name"
createnew $basedir/test/ ${src}Test "${name}Test" "$src.main" "${name}.main" "$idir" "$testdatadir"

test ! -d "$basedir/$testdatadir" && mkdir "$basedir/$testdatadir" 

