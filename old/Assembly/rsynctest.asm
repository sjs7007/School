data segment
msg1 db "Hello World!$"
data ends

code segment
start:
		mov ax,data
		mov ds,ax
		mov dx,offset msg1
		mov ah,09h
		int 21h

		mov ah,4ch
		int 21h
code ends
end start

