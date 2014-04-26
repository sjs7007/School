;find substring

data segment
msg1 db 0dh, "Enter String 1 : $"
msg2 db 0dh, "Enter substring to be searched : $"
msg3 db 0dh, "Substring match found. $"
msg4 db 0dh, "No substring match. $"

code segment
assume cs:code, ds:data

start:
	mov ax,data
	mov ds,ax

	mov dx,offset msg1
	mov ah,09h
	int 21h

end:
	mov ah,4ch
	int 21h

code ends
end start

