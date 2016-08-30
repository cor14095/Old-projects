#pragma once

namespace Calcu {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Summary for Form1
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
		Form1(void)
		{
			InitializeComponent();
			//
			//TODO: Add the constructor code here
			//
		}

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}

	protected: 
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::Button^  button7;
	private: System::Windows::Forms::Button^  button8;
	private: System::Windows::Forms::Button^  button9;
	private: System::Windows::Forms::Button^  button10;
	private: System::Windows::Forms::Button^  button11;
	private: System::Windows::Forms::Button^  button12;
	private: System::Windows::Forms::Button^  button13;
	private: System::Windows::Forms::Button^  button14;
	private: System::Windows::Forms::Button^  button15;
	private: System::Windows::Forms::Button^  button16;
	private: System::Windows::Forms::Button^  button17;
	private: System::Windows::Forms::Button^  button18;
	private: System::Windows::Forms::Button^  button19;
	private: System::Windows::Forms::Button^  button20;
	private: System::Windows::Forms::Button^  button21;
	private: System::Windows::Forms::Button^  button22;
	private: System::Windows::Forms::Button^  button23;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::TextBox^  textBox2;

	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->button7 = (gcnew System::Windows::Forms::Button());
			this->button8 = (gcnew System::Windows::Forms::Button());
			this->button9 = (gcnew System::Windows::Forms::Button());
			this->button10 = (gcnew System::Windows::Forms::Button());
			this->button11 = (gcnew System::Windows::Forms::Button());
			this->button12 = (gcnew System::Windows::Forms::Button());
			this->button13 = (gcnew System::Windows::Forms::Button());
			this->button14 = (gcnew System::Windows::Forms::Button());
			this->button15 = (gcnew System::Windows::Forms::Button());
			this->button16 = (gcnew System::Windows::Forms::Button());
			this->button17 = (gcnew System::Windows::Forms::Button());
			this->button18 = (gcnew System::Windows::Forms::Button());
			this->button19 = (gcnew System::Windows::Forms::Button());
			this->button20 = (gcnew System::Windows::Forms::Button());
			this->button21 = (gcnew System::Windows::Forms::Button());
			this->button22 = (gcnew System::Windows::Forms::Button());
			this->button23 = (gcnew System::Windows::Forms::Button());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->SuspendLayout();
			// 
			// button1
			// 
			this->button1->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button1->CausesValidation = false;
			this->button1->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button1->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button1->Location = System::Drawing::Point(9, 54);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(40, 33);
			this->button1->TabIndex = 1;
			this->button1->Text = L"<--";
			this->button1->UseVisualStyleBackColor = false;
			this->button1->Click += gcnew System::EventHandler(this, &Form1::button1_Click);
			// 
			// button2
			// 
			this->button2->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button2->CausesValidation = false;
			this->button2->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button2->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button2->Location = System::Drawing::Point(55, 54);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(40, 33);
			this->button2->TabIndex = 2;
			this->button2->Text = L"CE";
			this->button2->UseVisualStyleBackColor = false;
			this->button2->Click += gcnew System::EventHandler(this, &Form1::button2_Click);
			// 
			// button3
			// 
			this->button3->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button3->CausesValidation = false;
			this->button3->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button3->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button3->Location = System::Drawing::Point(101, 54);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(40, 33);
			this->button3->TabIndex = 3;
			this->button3->Text = L"C";
			this->button3->UseVisualStyleBackColor = false;
			this->button3->Click += gcnew System::EventHandler(this, &Form1::button3_Click);
			// 
			// button4
			// 
			this->button4->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button4->CausesValidation = false;
			this->button4->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button4->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button4->Location = System::Drawing::Point(147, 54);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(40, 33);
			this->button4->TabIndex = 4;
			this->button4->Text = L"±";
			this->button4->UseVisualStyleBackColor = false;
			this->button4->Click += gcnew System::EventHandler(this, &Form1::button4_Click);
			// 
			// button5
			// 
			this->button5->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button5->CausesValidation = false;
			this->button5->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button5->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button5->Location = System::Drawing::Point(193, 54);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(40, 33);
			this->button5->TabIndex = 5;
			this->button5->Text = L"√";
			this->button5->UseVisualStyleBackColor = false;
			this->button5->Click += gcnew System::EventHandler(this, &Form1::button5_Click);
			// 
			// button6
			// 
			this->button6->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button6->CausesValidation = false;
			this->button6->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button6->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button6->Location = System::Drawing::Point(9, 93);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(40, 33);
			this->button6->TabIndex = 6;
			this->button6->Text = L"7";
			this->button6->UseVisualStyleBackColor = false;
			this->button6->Click += gcnew System::EventHandler(this, &Form1::button6_Click);
			// 
			// button7
			// 
			this->button7->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button7->CausesValidation = false;
			this->button7->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button7->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button7->Location = System::Drawing::Point(55, 93);
			this->button7->Name = L"button7";
			this->button7->Size = System::Drawing::Size(40, 33);
			this->button7->TabIndex = 7;
			this->button7->Text = L"8";
			this->button7->UseVisualStyleBackColor = false;
			this->button7->Click += gcnew System::EventHandler(this, &Form1::button7_Click);
			// 
			// button8
			// 
			this->button8->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button8->CausesValidation = false;
			this->button8->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button8->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button8->Location = System::Drawing::Point(101, 93);
			this->button8->Name = L"button8";
			this->button8->Size = System::Drawing::Size(40, 33);
			this->button8->TabIndex = 8;
			this->button8->Text = L"9";
			this->button8->UseVisualStyleBackColor = false;
			this->button8->Click += gcnew System::EventHandler(this, &Form1::button8_Click);
			// 
			// button9
			// 
			this->button9->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button9->CausesValidation = false;
			this->button9->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button9->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button9->Location = System::Drawing::Point(147, 93);
			this->button9->Name = L"button9";
			this->button9->Size = System::Drawing::Size(40, 33);
			this->button9->TabIndex = 9;
			this->button9->Text = L"/";
			this->button9->UseVisualStyleBackColor = false;
			this->button9->Click += gcnew System::EventHandler(this, &Form1::button9_Click);
			// 
			// button10
			// 
			this->button10->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button10->CausesValidation = false;
			this->button10->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button10->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button10->Location = System::Drawing::Point(193, 93);
			this->button10->Name = L"button10";
			this->button10->Size = System::Drawing::Size(40, 33);
			this->button10->TabIndex = 10;
			this->button10->Text = L"%";
			this->button10->UseVisualStyleBackColor = false;
			this->button10->Click += gcnew System::EventHandler(this, &Form1::button10_Click);
			// 
			// button11
			// 
			this->button11->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button11->CausesValidation = false;
			this->button11->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button11->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button11->Location = System::Drawing::Point(9, 132);
			this->button11->Name = L"button11";
			this->button11->Size = System::Drawing::Size(40, 33);
			this->button11->TabIndex = 11;
			this->button11->Text = L"4";
			this->button11->UseVisualStyleBackColor = false;
			this->button11->Click += gcnew System::EventHandler(this, &Form1::button11_Click);
			// 
			// button12
			// 
			this->button12->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button12->CausesValidation = false;
			this->button12->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button12->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button12->Location = System::Drawing::Point(55, 132);
			this->button12->Name = L"button12";
			this->button12->Size = System::Drawing::Size(40, 33);
			this->button12->TabIndex = 12;
			this->button12->Text = L"5";
			this->button12->UseVisualStyleBackColor = false;
			this->button12->Click += gcnew System::EventHandler(this, &Form1::button12_Click);
			// 
			// button13
			// 
			this->button13->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button13->CausesValidation = false;
			this->button13->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button13->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button13->Location = System::Drawing::Point(101, 132);
			this->button13->Name = L"button13";
			this->button13->Size = System::Drawing::Size(40, 33);
			this->button13->TabIndex = 13;
			this->button13->Text = L"6";
			this->button13->UseVisualStyleBackColor = false;
			this->button13->Click += gcnew System::EventHandler(this, &Form1::button13_Click);
			// 
			// button14
			// 
			this->button14->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button14->CausesValidation = false;
			this->button14->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button14->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button14->Location = System::Drawing::Point(147, 132);
			this->button14->Name = L"button14";
			this->button14->Size = System::Drawing::Size(40, 33);
			this->button14->TabIndex = 14;
			this->button14->Text = L"*";
			this->button14->UseVisualStyleBackColor = false;
			this->button14->Click += gcnew System::EventHandler(this, &Form1::button14_Click);
			// 
			// button15
			// 
			this->button15->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button15->CausesValidation = false;
			this->button15->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button15->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button15->Location = System::Drawing::Point(193, 132);
			this->button15->Name = L"button15";
			this->button15->Size = System::Drawing::Size(40, 33);
			this->button15->TabIndex = 15;
			this->button15->Text = L"1/x";
			this->button15->UseVisualStyleBackColor = false;
			this->button15->Click += gcnew System::EventHandler(this, &Form1::button15_Click);
			// 
			// button16
			// 
			this->button16->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button16->CausesValidation = false;
			this->button16->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button16->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button16->Location = System::Drawing::Point(9, 171);
			this->button16->Name = L"button16";
			this->button16->Size = System::Drawing::Size(40, 33);
			this->button16->TabIndex = 16;
			this->button16->Text = L"3";
			this->button16->UseVisualStyleBackColor = false;
			this->button16->Click += gcnew System::EventHandler(this, &Form1::button16_Click);
			// 
			// button17
			// 
			this->button17->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button17->CausesValidation = false;
			this->button17->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button17->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button17->Location = System::Drawing::Point(55, 171);
			this->button17->Name = L"button17";
			this->button17->Size = System::Drawing::Size(40, 33);
			this->button17->TabIndex = 17;
			this->button17->Text = L"2";
			this->button17->UseVisualStyleBackColor = false;
			this->button17->Click += gcnew System::EventHandler(this, &Form1::button17_Click);
			// 
			// button18
			// 
			this->button18->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button18->CausesValidation = false;
			this->button18->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button18->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button18->Location = System::Drawing::Point(101, 171);
			this->button18->Name = L"button18";
			this->button18->Size = System::Drawing::Size(40, 33);
			this->button18->TabIndex = 18;
			this->button18->Text = L"1";
			this->button18->UseVisualStyleBackColor = false;
			this->button18->Click += gcnew System::EventHandler(this, &Form1::button18_Click);
			// 
			// button19
			// 
			this->button19->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button19->CausesValidation = false;
			this->button19->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button19->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button19->Location = System::Drawing::Point(147, 171);
			this->button19->Name = L"button19";
			this->button19->Size = System::Drawing::Size(40, 33);
			this->button19->TabIndex = 19;
			this->button19->Text = L"-";
			this->button19->UseVisualStyleBackColor = false;
			this->button19->Click += gcnew System::EventHandler(this, &Form1::button19_Click);
			// 
			// button20
			// 
			this->button20->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button20->CausesValidation = false;
			this->button20->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button20->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button20->Location = System::Drawing::Point(193, 171);
			this->button20->Name = L"button20";
			this->button20->Size = System::Drawing::Size(40, 72);
			this->button20->TabIndex = 20;
			this->button20->Text = L"=";
			this->button20->UseVisualStyleBackColor = false;
			this->button20->Click += gcnew System::EventHandler(this, &Form1::button20_Click);
			// 
			// button21
			// 
			this->button21->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button21->CausesValidation = false;
			this->button21->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button21->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button21->Location = System::Drawing::Point(9, 210);
			this->button21->Name = L"button21";
			this->button21->Size = System::Drawing::Size(86, 33);
			this->button21->TabIndex = 21;
			this->button21->Text = L"0";
			this->button21->UseVisualStyleBackColor = false;
			this->button21->Click += gcnew System::EventHandler(this, &Form1::button21_Click);
			// 
			// button22
			// 
			this->button22->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button22->CausesValidation = false;
			this->button22->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button22->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button22->Location = System::Drawing::Point(101, 210);
			this->button22->Name = L"button22";
			this->button22->Size = System::Drawing::Size(40, 33);
			this->button22->TabIndex = 22;
			this->button22->Text = L".";
			this->button22->UseVisualStyleBackColor = false;
			this->button22->Click += gcnew System::EventHandler(this, &Form1::button22_Click);
			// 
			// button23
			// 
			this->button23->BackColor = System::Drawing::SystemColors::MenuBar;
			this->button23->CausesValidation = false;
			this->button23->Cursor = System::Windows::Forms::Cursors::Hand;
			this->button23->FlatStyle = System::Windows::Forms::FlatStyle::System;
			this->button23->Location = System::Drawing::Point(147, 210);
			this->button23->Name = L"button23";
			this->button23->Size = System::Drawing::Size(40, 33);
			this->button23->TabIndex = 23;
			this->button23->Text = L"+";
			this->button23->UseVisualStyleBackColor = false;
			this->button23->Click += gcnew System::EventHandler(this, &Form1::button23_Click);
			// 
			// textBox1
			// 
			this->textBox1->BackColor = System::Drawing::SystemColors::Window;
			this->textBox1->BorderStyle = System::Windows::Forms::BorderStyle::None;
			this->textBox1->CausesValidation = false;
			this->textBox1->ForeColor = System::Drawing::SystemColors::ActiveCaptionText;
			this->textBox1->Location = System::Drawing::Point(8, 28);
			this->textBox1->Margin = System::Windows::Forms::Padding(0);
			this->textBox1->Multiline = true;
			this->textBox1->Name = L"textBox1";
			this->textBox1->ReadOnly = true;
			this->textBox1->RightToLeft = System::Windows::Forms::RightToLeft::No;
			this->textBox1->Size = System::Drawing::Size(224, 20);
			this->textBox1->TabIndex = 24;
			// 
			// textBox2
			// 
			this->textBox2->BackColor = System::Drawing::SystemColors::Window;
			this->textBox2->BorderStyle = System::Windows::Forms::BorderStyle::None;
			this->textBox2->CausesValidation = false;
			this->textBox2->Location = System::Drawing::Point(8, 8);
			this->textBox2->Margin = System::Windows::Forms::Padding(0);
			this->textBox2->Multiline = true;
			this->textBox2->Name = L"textBox2";
			this->textBox2->ReadOnly = true;
			this->textBox2->RightToLeft = System::Windows::Forms::RightToLeft::No;
			this->textBox2->Size = System::Drawing::Size(224, 20);
			this->textBox2->TabIndex = 25;
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::GradientActiveCaption;
			this->ClientSize = System::Drawing::Size(239, 247);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->button23);
			this->Controls->Add(this->button22);
			this->Controls->Add(this->button21);
			this->Controls->Add(this->button20);
			this->Controls->Add(this->button19);
			this->Controls->Add(this->button18);
			this->Controls->Add(this->button17);
			this->Controls->Add(this->button16);
			this->Controls->Add(this->button15);
			this->Controls->Add(this->button14);
			this->Controls->Add(this->button13);
			this->Controls->Add(this->button12);
			this->Controls->Add(this->button11);
			this->Controls->Add(this->button10);
			this->Controls->Add(this->button9);
			this->Controls->Add(this->button8);
			this->Controls->Add(this->button7);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Name = L"Form1";
			this->Text = L"Calculadora";
			this->Load += gcnew System::EventHandler(this, &Form1::Form1_Load);
			this->KeyPress += gcnew System::Windows::Forms::KeyPressEventHandler(this, &Form1::Form1_KeyPress);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		int temp,pnt;
		Boolean div, sum, res, mul;
	private: System::Void Form1_Load(System::Object^  sender, System::EventArgs^  e) {
				 Form1::Focused;
				 temp = 0;
			 }
private: System::Void button18_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "1";
		 }
private: System::Void button17_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "2";
		 }
private: System::Void button21_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "0";
		 }
private: System::Void button22_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text->IndexOf(".") == -1) {
			 textBox1->Text += ".";
			 }
		 }
private: System::Void button16_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "3";
		 }
private: System::Void button13_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "6";
		 }
private: System::Void button12_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "5";
		 }
private: System::Void button11_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "4";
		 }
private: System::Void button8_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "9";
		 }
private: System::Void button7_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "8";
		 }
private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text += "7";
		 }
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text = "";
			 textBox2->Text = "";
			 temp = 0;
			 div = sum = res = mul = false;
			 pnt = 0;
		 }
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 String^ del = textBox1->Text;
				 textBox1->Text = del->Substring(0, (del->Length)-1);
			 } else
			 {}
		 }
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 textBox1->Text = Convert::ToString(a*-1);
			 } else {
				if (textBox2->Text != "") {
					Double b = Convert::ToDouble(textBox2->Text);
					textBox2->Text = Convert::ToString(b*-1);
				}
			 }

		 }
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
			 textBox1->Text = "";
			 pnt = 0;
		 }
private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 if (temp == 0) 
					 if (a<0) 
						 MessageBox::Show("Raiz negativa");
					 else {
					 textBox2->Text = Convert::ToString(Math::Sqrt(a));
					 textBox1->Text = "";
					 temp = 1;
					 }
				 else {
					 Double b = Convert::ToDouble(textBox2->Text);
					 textBox2->Text = Convert::ToString(Math::Sqrt(b));
				 }
			 } else {
				 Double b = Convert::ToDouble(textBox2->Text);
				 if (temp != 0) {
					 if (b<0) 
						 MessageBox::Show("Raiz negativa");
					 else 
						textBox2->Text = Convert::ToString(Math::Sqrt(b));
				 }
			 }
		 }
private: System::Void button9_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 if (temp == 0) {
					 textBox2->Text = Convert::ToString(a);
					 textBox1->Text = "";
					 temp = 1;
					 div = true;
				 } else
					 if ((textBox1->Text == "0")|(textBox1->Text == ""))
						 MessageBox::Show("División no valida");
					 else
					 {
						 textBox2->Text = Convert::ToString( (Convert::ToDouble(textBox2->Text)) / a);
						 textBox1->Text = "";
					 }
			 }
		 }
private: System::Void button14_Click(System::Object^  sender, System::EventArgs^  e) {
			 	 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 if (temp == 0) {
					 textBox2->Text = Convert::ToString(a);
					 textBox1->Text = "";
					 temp = 1;
					 mul = true;
				 } else {
						 textBox2->Text = Convert::ToString( (Convert::ToDouble(textBox2->Text)) * a);
						 textBox1->Text = "";
					 }
			 }
		 }
private: System::Void button10_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (((div)|(sum)|(res)|(mul))&&(textBox1->Text != "")) {
				 Double a = Convert::ToDouble(textBox2->Text);
				 Double b = Convert::ToDouble(textBox1->Text);

				 textBox1->Text = Convert::ToString(b*(a/100));
			 }
		 }
private: System::Void button15_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 pnt = 0;
				 if (temp == 0) {
					 textBox2->Text = Convert::ToString(1/a);
					 textBox1->Text = "";
					 temp = 1;
					} else {
					 Double b = Convert::ToDouble(textBox2->Text);
					 textBox2->Text = Convert::ToString(1/b);
					}
			} else 
				 if (temp != 0) {
					 Double b = Convert::ToDouble(textBox2->Text);
					 textBox2->Text = Convert::ToString(1/b);
				 }
		 }
private: System::Void button19_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 if (temp == 0) {
					 textBox2->Text = Convert::ToString(a);
					 textBox1->Text = "";
					 temp = 1;
					 res = true;
				 } else {
						 textBox2->Text = Convert::ToString( (Convert::ToDouble(textBox2->Text)) - a);
						 textBox1->Text = "";
					 }
			 }
		 }
private: System::Void button23_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (textBox1->Text != "") {
				 Double a = Convert::ToDouble(textBox1->Text);
				 if (temp == 0) {
					 textBox2->Text = Convert::ToString(a);
					 textBox1->Text = "";
					 temp = 1;
					 sum = true;
				 } else {
						 textBox2->Text = Convert::ToString( (Convert::ToDouble(textBox2->Text)) + a);
						 textBox1->Text = "";
					 }
			 }
		 }
private: System::Void button20_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (div)
			 {
				 textBox1->Text = Convert::ToString((Convert::ToDouble(textBox2->Text)) / (Convert::ToDouble(textBox1->Text)));
				 div = false;
				 textBox2->Text = "";
				 temp = 0;
				 pnt = 0;
			 }
			 if (mul)
			 {
				 textBox1->Text = Convert::ToString((Convert::ToDouble(textBox2->Text)) * (Convert::ToDouble(textBox1->Text)));
				 mul = false;
				 textBox2->Text = "";
				 temp = 0;
				 pnt = 0;
			 }
			 if (sum)
			 {
				 textBox1->Text = Convert::ToString((Convert::ToDouble(textBox2->Text)) + (Convert::ToDouble(textBox1->Text)));
				 sum = false;
				 textBox2->Text = "";
				 temp = 0;
				 pnt = 0;
			 }
			 if (res)
			 {
				 textBox1->Text = Convert::ToString((Convert::ToDouble(textBox2->Text)) - (Convert::ToDouble(textBox1->Text)));
				 res = false;
				 textBox2->Text = "";
				 temp = 0;
				 pnt = 0;
			 }
		 }
private: System::Void Form1_KeyPress(System::Object^  sender, System::Windows::Forms::KeyPressEventArgs^  e) {
		 }

};
}

