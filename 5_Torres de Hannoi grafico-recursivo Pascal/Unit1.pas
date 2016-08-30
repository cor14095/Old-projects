unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, StdCtrls;

type
  TForm1 = class(TForm)
    Button1: TButton;
    Button2: TButton;
    Label1: TLabel;
    procedure FormCreate(Sender: TObject);
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

  TTorre = class
    private
      form: Tform;
      torre: TShape;
      left,p,base: integer;
      an: array [1..10] of TShape;
    public
      constructor makenull(n:integer; f:Tform);
      procedure anillos;
      //procedure mover (e:TShape; p1,p2: Integer);
      procedure push (e:TShape; t:TTorre);
      function pop(t:TTorre): TShape;
  end;

var
  Form1: TForm1;
  i,ca: Integer;
  torres: array [1..3] of TTorre;

implementation

constructor TTorre.makenull(n: Integer; f: TForm);
begin
  torre:= TShape.Create(f);
  torre.Parent:= f;
  torre.Top:= 200;
  left:= n*250-50;
  torre.Left:= left;
  torre.Width:= 2;
  torre.Height:= 300;
  //base:= 200;
  p:= 0; Form:= f;
end;

Procedure TTorre.anillos;
begin
  inc(p);
  an[p]:= TShape.Create(form);
  an[p].Parent:= form;

  an[p].Height:= 20;
  an[p].Width:= 200-10*p;
  an[p].Top:= 500-20*p;
  an[p].Left:= left-an[p].Width div 2;
  an[p].Brush.Color:= random(1000000);

end;

Procedure TTorre.push(e: TShape; t: TTorre);
begin
    e.Left:=left-e.Width div 2;
  inc(t.p);
  t.an[t.p]:=e;
  for i := 150 to 500-20*p do
    Begin
      e.Top:=i;
      sleep(1);
      Application.ProcessMessages;
    End;
end;

Function TTorre.pop(t: TTorre): TShape;
begin
    for i := 500-20*p downto 150 do
    Begin
      t.an[t.p].Top:=i;
      sleep(1);
      Application.ProcessMessages;
    End;
  Pop:= t.an[t.p];
  dec(t.p);
end;

Procedure Hanoi(n:integer; t1,t2,t3:TTorre);
Begin
  if n=1 then begin
    t3.push(t1.pop(t1),t3);
  end else
    Begin
      hanoi(n-1,t1,t3,t2);
      hanoi(1  ,t1,t2,t3);
      hanoi(n-1,t2,t1,t3);
    End;
End;

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
begin
Torres[1].anillos;
if Torres[1].p = 10 then
  Button1.Enabled:= False;

Button2.Enabled:= True;
end;

procedure TForm1.Button2Click(Sender: TObject);
begin
hanoi(Torres[1].p, Torres[1],Torres[2],Torres[3]);
end;

procedure TForm1.Button3Click(Sender: TObject);
begin
  for i := 1 to 3 do
    Torres[i]:= TTorre.makenull(i,self);
end;

procedure TForm1.FormCreate(Sender: TObject);
begin
randomize;
ca:=1;
  for i := 1 to 3 do
    Torres[i]:= TTorre.makenull(i,self);
end;

end.