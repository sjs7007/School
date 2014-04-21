data segment
msg1 db 0dh,0ah,"msg1$"
msg2 db 0dh,0ah,"msg2$"
data ends

code segment
assume cs:code,ds:data
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