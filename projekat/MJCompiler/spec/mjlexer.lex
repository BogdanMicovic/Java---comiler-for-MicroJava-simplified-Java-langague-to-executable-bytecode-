
package rs.ac.bg.etf.pp1; //IMPORT SEKCIJA

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena - SEKCIJA KODA
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

//SEKCIJA DIREKTIVA - nas analizator implementira interfejs cup i tokom rada broji linije i kolone
//2 stanja- 1. obrada komentara, 2. citanje ulaznih sekvenci 

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}


//SEKCIJA REGULARNIH IZRAZA - na osnovu regularnih izraza omogucavamo akcije kada se okine neki od tih regularnih izraza
//kada se prepozna neki beli znak ignorisi- nema akcije
// svi regularni izrazi se razmatraju u istom stanju - stanje 2. tj. citanje ulaznih sekvenci
//to nije bitno naglasiti za regularne izraze jer je podrazumevano ali je bitno kod komentara napraviti novo stanje
%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROGRAM, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"=" 		{ return new_symbol(sym.ASSIGN, yytext()); }
";" 		{ return new_symbol(sym.SEMICOMMA, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LBRACKET, yytext()); }
")" 		{ return new_symbol(sym.RBRACKET, yytext()); }
"{" 		{ return new_symbol(sym.LCURLY, yytext()); }
"}"			{ return new_symbol(sym.RCURLY, yytext()); }
"break"     { return new_symbol(sym.BREAK, yytext());}
"class"     { return new_symbol(sym.CLASS, yytext());}
"abstract"  { return new_symbol(sym.ABSTRACT, yytext());}
"else"      { return new_symbol(sym.ELSE, yytext());}
"const"     { return new_symbol(sym.CONST, yytext());}
"if"        { return new_symbol(sym.IF, yytext());}
"new"       { return new_symbol(sym.NEW, yytext());}
"read"      { return new_symbol(sym.READ, yytext());}
"-"         { return new_symbol(sym.MINUS, yytext());}
"*"         { return new_symbol(sym.MUL, yytext());}
"/"         { return new_symbol(sym.DIV, yytext());}
"%"         { return new_symbol(sym.PERCENT, yytext());}
"!="        { return new_symbol(sym.DIFFERENT, yytext());}
">"         { return new_symbol(sym.BIGGER, yytext());}
">="        { return new_symbol(sym.BIGGEREQ, yytext());}
"<"         { return new_symbol(sym.LESS, yytext());}
"<="        { return new_symbol(sym.LESSEQ, yytext());}
"&&"        { return new_symbol(sym.AND, yytext());}
"||"        { return new_symbol(sym.OR, yytext());}
"=="        { return new_symbol(sym.EQUAL, yytext());}
"++"        { return new_symbol(sym.INC, yytext());}
"--"        { return new_symbol(sym.DEC, yytext());}
"."         { return new_symbol(sym.DOT, yytext());}
"["         { return new_symbol(sym.LSQUARE, yytext());}
"]"         { return new_symbol(sym.RSQUARE, yytext());}
"for"       { return new_symbol(sym.FOR, yytext());}
"continue"  { return new_symbol(sym.CONTINUE, yytext());}
"extends"   { return new_symbol(sym.EXTENDS, yytext());}
"foreach"   { return new_symbol(sym.FOREACH, yytext());}
":"         { return new_symbol(sym.COLON, yytext());}
"+="		{ return new_symbol(sym.PLUSEQUAL, yytext());}
"-="        { return new_symbol(sym.MINUSEQUAL, yytext());}
"*="        { return new_symbol(sym.MULEQUAL, yytext());}
"/="        { return new_symbol(sym.DIVEQUAL, yytext());}
"%="        { return new_symbol(sym.PERCENTEQUAL, yytext());}
"$"        { return new_symbol(sym.DOLAR, yytext());}
"//" {yybegin(COMMENT);} //prelazimo u stanje obrade komentara
<COMMENT> . {yybegin(COMMENT);} //tacka znaci citaj bilo koji znak, a zatim sledi akcija ostanka u stanju COMMENT tj. citanaj komentara
<COMMENT> "\r\n" { yybegin(YYINITIAL); } // prelazimo u stanje INITIAL kada dodjemo do novog reda

[0-9]+  { return new_symbol(sym.NUM, new Integer (yytext())); }
\'([a-z]|[A-Z])\'{1} {return new_symbol(sym.CHAR, new Character(yytext().charAt(1)));}
(true|false) { return new_symbol(sym.BOOL, new Boolean (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)+" na poziciji "+(yycolumn+1));}




