unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    Label2: TLabel;
    Memo1: TMemo;
    Button1: TButton;
    OpenDialog1: TOpenDialog;
    procedure FormCreate(Sender: TObject);
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  lab: TextFile;
  mat: array [1..1000,1..1000] of integer;
  tx,ty:integer;
  h,w: integer;
  s: String;

implementation

uses Unit2;

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
begin
h:=0;
w:=0;
s:='';

for tx := 1 to 1000 do
       for ty := 1 to 1000 do
         mat[tx,ty]:=0;

if OpenDialog1.Execute then
  Begin
    assignfile(lab, OpenDialog1.FileName);
    Reset(lab);
    while (not(EoF(lab))) do
      Begin
        readln(lab, s);
        if w<Length(s) then
          w:= Length(s);
        inc(h);
      End;

    tx:= 50;
    ty:= 50;
    while (w*tx>1300) or (h*ty>1000) do Begin
      tx:= tx div 2; ty:= ty div 2;
    End;

    Form2.ClientWidth:= w*tx;
    Form2.ClientHeight:= h*ty;
    Image1.Width:= Form2.ClientWidth;
    Image1.Height:= Form2.ClientHeight;
    Image1.Canvas.Brush.Color:= ClOlive;
    Image1.Canvas.Rectangle(0,0,Form2.ClientWidth,Form2.ClientHeight);
    Form2.Caption:= 'Laberinto  '+IntToStr(Image1.Height)+' '+IntToStr(Image1.Width)+'  '+IntToStr(tx*h)+' '+IntToStr(ty*w);
    Form2.Show;
    MessageDLG('Para moverse utilice los comandos:'+#13+
                'W: Arriba'+#13+
                'A: Izquierda'+#13+
                'S: Abajo'+#13+
                'D: Derecha'+#13+
                'El Objetivo es llegar a la salida (punto amarillo) sin tocar las paredes del templo', MTInformation, [MbOk], 0);
  End;
end;

procedure TForm1.FormCreate(Sender: TObject);
begin
Memo1.Clear;
Label2.Caption:=
'Para crear un laberinto en un block de notas'+#13+
'cree el patron del laberinto usando los simbolos:'+#13+
'-> Cualquier caracter que no sea un "0" o un espacio en blanco " " sera una pared'+#13+
'-> " " (sin comillas) para un espacio en blanco'+#13+
'-> "*" (cero sin comillas) para la salida del laberinto'+#13+
'-> El personaje siempre empezara en la posicion [2,2], porfavor dejala bacia.'+#13+
#13+
'Como este ejemplo, donde "p" es donde siempre empieza el personaje';
Label2.Width:= 450;

Memo1.Top:= 310;
Memo1.Left:= Label2.Left;
Memo1.Height:= 100;
Memo1.Width:= 100;
Memo1.ReadOnly:= True;
Memo1.Lines.Add('|-|    |-|');
Memo1.Lines.Add('| |    |*|');
Memo1.Lines.Add('| |    | |');
Memo1.Lines.Add('| |____| |');
Memo1.Lines.Add('|        |');
Memo1.Lines.Add('----------');

Button1.Top:= 420;
Button1.Left:= Label2.Left;
end;

end.
