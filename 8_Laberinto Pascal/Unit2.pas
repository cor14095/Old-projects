unit Unit2;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, StdCtrls, pngimage;

type
  TForm2 = class(TForm)
    procedure FormKeyPress(Sender: TObject; var Key: Char);
    procedure FormShow(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form2: TForm2;
  m: TImage;
  x,y: integer;
  Image1: TImage;
  b: boolean;

implementation

uses unit1;
Procedure zumbido (f: TForm);
var
i: integer;
Begin
  for i := 1 to 100 do
    Begin
      f.Left:= f.Left-10;
      f.Top:= f.Top+10;
      f.Left:= f.Left+10;
      f.Top:= f.Top-10;
    End;
End;

Procedure bloque(x,y:integer; m:TImage);
Begin
m.Canvas.Brush.Color:= ClGray;
m.Canvas.Rectangle(ty*(y-1),tx*(x-1),ty*(y-1)+ty,tx*(x-1)+tx);
End;

Procedure objetos(x,y: Integer);
Begin
  m:= TImage.Create(Form2);
  m.Parent:= Form2;

  m.Picture.LoadFromFile('tipo.png');
  m.Stretch:= True;
  m.Width:= tx;
  m.Height:= ty;
  m.Top:= ty;
  m.Left:= tx;

  mat[2,2]:= 3;

  Image1.Canvas.Brush.Color:= ClYellow;
  Image1.Canvas.Ellipse(ty*(y-1),tx*(x-1),ty*(y-1)+ty,tx*(x-1)+tx);

End;

Procedure Salida(x,y:integer);
Begin
  if (mat[x,y]=2) then
    Begin
      Zumbido(form2);
      showmessage('GANASTE!');
      b:= true;
    End
  else
    if (mat[x,y]=1) then
      begin end
    else
      Begin
        m.Top:=ty*(x-1);
        m.Left:=tx*(y-1);
        sleep(100); Application.ProcessMessages;
        mat[x,y]:=1;
        salida(x-1,y);
        if not b then
          salida(x,y-1);
        if not b then
          salida(x+1,y);
        if not b then
          salida(x,y+1);
        if not b then Begin
          m.Top:=ty*(x-1);
          m.Left:=tx*(y-1);
          sleep(100); Application.ProcessMessages;
        End;
    End;

End;
{$R *.dfm}

procedure TForm2.FormClose(Sender: TObject; var Action: TCloseAction);
begin
m.Free;
image1.Free;
Image1 := Timage.Create(self);
Image1.Parent:= self;
end;

procedure TForm2.FormCreate(Sender: TObject);
begin
Image1 := Timage.Create(self);
Image1.Parent:= self;
end;

procedure TForm2.FormKeyPress(Sender: TObject; var Key: Char);
begin
case key of
  'a':Begin
        if not (mat[x,y-1]=1) then
          Begin
            mat[x,y]:=0;
            dec(y);
            if mat[x,y]=2 then
              Begin
                showmessage('GANASTE!');
                Form2.Close;
              End;
            mat[x,y]:=3;
            m.Left:=m.Left-ty;
          End
        else
          zumbido(self);
      End;
  'w':Begin
        if not (mat[x-1,y]=1) then
          Begin
            mat[x,y]:=0;
            dec(x);
            if mat[x,y]=2 then
              Begin
                showmessage('GANASTE!');
                Form2.Close;
              End;
            mat[x,y]:=3;
            m.Top:=m.Top-tx;
          End
        else
          zumbido(self);
      End;
  'd':Begin
        if not (mat[x,y+1]=1) then
          Begin
            mat[x,y]:=0;
            inc(y);
            if mat[x,y]=2 then
              Begin
                showmessage('GANASTE!');
                Form2.Close;
              End;
            mat[x,y]:=3;
            m.Left:=m.Left+ty;
          End
        else
          zumbido(self);
      End;
  's':Begin
        if not (mat[x+1,y]=1) then
          Begin
            mat[x,y]:=0;
            inc(x);
            if mat[x,y]=2 then
              Begin
                showmessage('GANASTE!');
                Form2.Close;
              End;
            mat[x,y]:=3;
            m.Top:=m.Top+tx;
          End
        else
          zumbido(self);
      End;
  #13:Begin
        Showmessage('Muy dificil?');
        b:= False;
        salida(x,y);
      End;
end;
if b then
  form2.Close;
end;

procedure TForm2.FormShow(Sender: TObject);
begin
x:= 0;
b:= False;
reset(lab);
while (Not(EoF(lab))) do
  Begin
    ReadLn(lab, s);
    for y := 1 to Length(s) do
      Begin
        if (s[y]<>'*') and (s[y]<>' ') then
          Begin
            Bloque(x+1,y, Image1);
            mat[x+1,y]:= 1;
          End
        else
          if s[y]='*' then
            Begin
              objetos(x+1,y);
              mat[x+1,y]:=2;
            End;
      End;
    inc(x);
  End;

x:= 2;
y:= 2;

Closefile(lab);
Form2.Setfocus;
end;

end.
