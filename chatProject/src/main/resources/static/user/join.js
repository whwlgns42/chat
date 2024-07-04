

// 회원가입
function joinBtn() {
				    event.preventDefault(); // 기본 동작 차단

				    // 필수 입력 필드 확인
				    var isValid = true;
				    if ($("#name").val() === "") {
				        alert("이름을 입력해 주세요.");
				        $("#name").focus();
				        isValid = false;
				    } else if ($("#age").val() === "") {
				        alert("나이를 입력해 주세요.");
				        $("#age").focus();
				        isValid = false;
				    } else if ($("#userId").val() === "") {
				        alert("아이디를 입력해 주세요.");
				        $("#userId").focus();
				        isValid = false;
				    } else if ($("#password").val() === "") {
				        alert("비밀번호를 입력해 주세요.");
				        $("#password").focus();
				        isValid = false;
				    } else if ($("#email").val() === "") {
				        alert("이메일을 입력해 주세요.");
				        $("#email").focus();
				        isValid = false;
				    } else if ($("#mobile").val() === "") {
				        alert("휴대폰 번호를 입력해 주세요.");
				        $("#mobile").focus();
				        isValid = false;
				    }

				    if (isValid) {
				        var formData = {
				            name: $("#name").val(),
				            age: $("#age").val(),
				            userId: $("#userId").val(),
				            password: $("#password").val(),
				            email: $("#email").val(),
				            mobile: $("#mobile").val()
				        };

				        $.ajax({
				            type: "POST",
				            url: "/join",
				            data: JSON.stringify(formData),
				            contentType: "application/json; charset=utf-8",
				            dataType: "text",
				            success: function(data) {
				                if (data != formData.userId) {
				                    // 회원가입 성공 시 추가 처리 로직 작성
				                    alert("회원가입이 완료되었습니다.");
									location.href = "/"
				                } else {
				                    alert("이미 존재함"); // 서버에서 반환한 오류 메시지 출력
				                }
				            },
				            error: function(xhr, status, error) {
				                alert("회원가입에 실패했습니다. 다시 시도해 주세요.");
				                // 회원가입 실패 시 추가 처리 로직 작성
				            }
				        });
				    }
				}