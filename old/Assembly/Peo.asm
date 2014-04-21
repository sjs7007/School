data segment
msg0 db "Enter number : $"
msg1 db "Number is even.$"
msg2 db "Number is odd.$"
data ends

code segment 
assume ds:data,cs:code
start:	mov ax,data
	mov ds,ax
	mov dx,offset msg0
	mov ah,09h
	int 21h

up:	mov ah,01h
	int 21h
	mov [si],al ;move input number to stack
	inc si
	cmp al,0dh
	jnz up ; if enter is not pressed, continue taking input
	sub si,02h
	mov al,[si]
	ror al,01h ;rotate over right
	jnc evens ;even seems to be a fucking keyword! using it causes error
	mov dx,offset msg2

print:	mov ah,09h
	int 21h
	mov ah,4ch
	int 21h

evens:	mov dx,offset msg1
	jmp print

code ends
end start
