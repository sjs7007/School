;code 3 : Find max. of 10 numbers

data segment
msg1 db 0dh,0ah, "Enter a number : $"
msg2 db 0ah,"Maximumm of the input is : $"
data ends

code segment
start:	mov ax,data
		mov ds,ax

		mov si,6000h
		mov [si],0h
		mov cl,0ah ;0ah for 10 numbers

s:		mov dx,offset msg1
		mov ah,09h
		int 21h

s1:		mov ah,01h
		int 21h
		cmp al,byte ptr[si]
		jge s2

s4:		dec cl
		cmp cl,00h
		jnz s
		jmp s3

s2:		mov [si],al
		jmp s4

s3:		mov dx,offset msg2
		mov ah,09h
		int 21h

		mov bx,[si]
		mov dx,bx	
		mov ah,02h
		int 21h
		mov ah,4ch
		int 21h

code ends
end start
