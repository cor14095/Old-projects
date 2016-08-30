unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, StdCtrls, unit2, ComCtrls;

type
  TForm1 = class(TForm)
    Panel1: TPanel;
    LabeledEdit2: TLabeledEdit;
    LabeledEdit3: TLabeledEdit;
    LabeledEdit4: TLabeledEdit;
    Button2: TButton;
    LabeledEdit5: TLabeledEdit;
    Button3: TButton;
    Image1: TImage;
    CheckBox1: TCheckBox;
    LabeledEdit1: TLabeledEdit;
    LabeledEdit6: TLabeledEdit;
    LabeledEdit7: TLabeledEdit;
    LabeledEdit8: TLabeledEdit;
    ProgressBar1: TProgressBar;
    LabeledEdit9: TLabeledEdit;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
    procedure Image1MouseMove(Sender: TObject; Shift: TShiftState; X,
      Y: Integer);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  fx: TPostfix;
  paso,lix,lsx,liy,lsy: Real;
  x1,y1 :real;
  graf: boolean;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
begin
if LabeledEdit1.Text <> '' then
  fx:= Tpostfix.mcreate(LabeledEdit1.Text)
else
  showmessage('String nulo');

Panel1.Visible:= True;
end;

procedure TForm1.Button2Click(Sender: TObject);
var
i: integer;
begin
if LabeledEdit1.Text <> '' then
  fx:= Tpostfix.mcreate(LabeledEdit1.Text)
else
  showmessage('String nulo');

LabeledEdit7.Text:= FloatToStr(fx.eval(StrToInt(LabeledEdit6.Text),0,0));
end;

procedure TForm1.Button3Click(Sender: TObject);

Function xp(x:real):integer;
  Begin
    xp:= Round(((x-lix)*image1.Width)/(lsx-lix));
  End;

Function yp(y:real):integer;
  Begin
    yp:= round(((lsy-y)*image1.Height)/(lsy-liy));
  End;

begin

  if LabeledEdit1.Text = '' then
    showmessage('String nulo')
  else
    Begin
      graf:= False;
      fx:= Tpostfix.mcreate(LabeledEdit1.Text);

      lix:= StrToFloat(LabeledEdit3.Text);
      lsx:= StrToFloat(LabeledEdit2.Text);

      paso:= (lsx-lix)/100;
      x1:= lix; y1:= fx.eval(x1,0,0);

      if not CheckBox1.Checked then
        Begin
          liy:= y1; lsy:= y1;
          while x1 <= lsx do begin
            x1:= x1+paso;
            y1:= fx.eval(x1,0,0);
            if y1 < liy then liy:= y1;
            if y1 > liy then lsy:= y1;
          end;
        End
      else
        Begin
          liy:= StrToInt(LabeledEdit5.Text);
          lsy:= StrToInt(LabeledEdit4.Text);
        End;

      x1:= lix; y1:= fx.eval(x1,0,0);
      Image1.Canvas.MoveTo(xp(x1), yp(y1));

      Image1.Canvas.Pen.Width:= 1;
      Image1.Canvas.Rectangle(-1,-1, Image1.Height+1, Image1.Width+1);
      Image1.Canvas.Pen.Width:= 3;
      Image1.Canvas.Pen.Color:= ClRed;

      ProgressBar1.Min:= 0;
      ProgressBar1.Max:= Round(lsx-lix);
      ProgressBar1.Position:= 0;

      while x1 <= lsx do
        Begin
          x1:= x1+paso;
          y1:= fx.eval(x1,0,0);
          ProgressBar1.Position:= round(x1)*2;
          sleep(10);
          Application.ProcessMessages;
          Image1.Canvas.LineTo(xp(x1), yp(y1));
          Image1.Canvas.MoveTo(xp(x1), yp(y1));
        End;

      Image1.Canvas.Pen.Width:= 3;
      Image1.Canvas.Pen.Color:= ClBlack;

      Image1.Canvas.MoveTo(xp(0), 0);
      Image1.Canvas.LineTo(xp(0), Image1.Height);
      Image1.Canvas.MoveTo(0, yp(0));
      Image1.Canvas.LineTo(Image1.Width, yp(0));

      graf:= True;
    End;
end;

procedure TForm1.Image1MouseMove(Sender: TObject; Shift: TShiftState; X,
  Y: Integer);

var
x2, y2: real;

Function xp(x:real):integer;
  Begin
    xp:= Round(((x-lix)*image1.Width)/(lsx-lix));
  End;

Function yp(y:real):integer;
  Begin
    yp:= round(((lsy-y)*image1.Height)/(lsy-liy));
  End;

begin
  if graf then
    Begin
      x2:= lix; y2:= fx.eval(x2,0,0);

      Image1.Canvas.Rectangle(-10,-10,Image1.Height+10,Image1.Width+10);

      Image1.Canvas.Pen.Color:= ClGray;

      Image1.Canvas.MoveTo(xp(x), 0);
      Image1.Canvas.LineTo(xp(x), Image1.Height);
      Image1.Canvas.MoveTo(0, yp(fx.eval(x,0,0)));
      Image1.Canvas.LineTo(Image1.Width, yp(fx.eval(x,0,0)));

      Image1.Canvas.Pen.Color:= ClRed;
      Image1.Canvas.MoveTo(xp(x2), yp(y2));
      while x2 <= lsx do
        Begin
          x2:= x2+paso;
          y2:= fx.eval(x2,0,0);
          Image1.Canvas.LineTo(xp(x2), yp(y2));
          Image1.Canvas.MoveTo(xp(x2), yp(y2));
        End;

      Image1.Canvas.Pen.Width:= 3;
      Image1.Canvas.Pen.Color:= ClBlack;

      Image1.Canvas.MoveTo(xp(0), 0);
      Image1.Canvas.LineTo(xp(0), Image1.Height);
      Image1.Canvas.MoveTo(0, yp(0));
      Image1.Canvas.LineTo(Image1.Width, yp(0));

      LabeledEdit8.Text:= '('+IntToStr(X-xp(0))+', '+IntToStr(yp(0)-Y)+')';

      LabeledEdit9.Text:= FloatToStr(fx.eval(X-xp(0),0,0));

    End;
end;

end.
