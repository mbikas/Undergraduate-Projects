function varargout = cse200(varargin)
% CSE200 M-file for cse200.fig
%      CSE200, by itself, creates a new CSE200 or raises the existing
%      singleton*.
%
%      H = CSE200 returns the handle to a new CSE200 or the handle to
%      the existing singleton*.
%
%      CSE200('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in CSE200.M with the given input arguments.
%
%      CSE200('Property','Value',...) creates a new CSE200 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before cse200_OpeningFunction gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to cse200_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Copyright 2002-2003 The MathWorks, Inc.

% Edit the above text to modify the response to help cse200

% Last Modified by GUIDE v2.5 02-Jan-2003 00:36:41

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @cse200_OpeningFcn, ...
                   'gui_OutputFcn',  @cse200_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before cse200 is made visible.
function cse200_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to cse200 (see VARARGIN)

% Choose default command line output for cse200
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes cse200 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = cse200_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;



function edit1_Callback(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit1 as text
%        str2double(get(hObject,'String')) returns contents of edit1 as a double


% --- Executes during object creation, after setting all properties.
function edit1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end



function edit2_Callback(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit2 as text
%        str2double(get(hObject,'String')) returns contents of edit2 as a double


% --- Executes during object creation, after setting all properties.
function edit2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%///////////////////////////////////////////////////////

axes(handles.axes1); 
cla;
axes(handles.axes2); 
cla;

axes(handles.axes2); 
str1 = get ( handles.edit1, 'string');
handles.amp = str2double( str1 );

str2 = get ( handles.edit2, 'string');
handles.width = str2double( str2 );

if(handles.amp<0)
   handles.amp=-handles.amp; 
end;   
if(handles.width<0)
   handles.width=-handles.width; 
end;   

set( handles.axes2, 'XLim', [-handles.width*2 handles.width*2], 'YLim', [-handles.amp*2 handles.amp*2]);

handles.l1 = line( 'XData',[-handles.width -handles.width], 'YData',[0  handles.amp],'color','blue' );
handles.l2 = line('XData',[-handles.width (handles.width)],'YData',[handles.amp handles.amp],'color','blue' );
handles.l3 = line('XData',[(handles.width) (handles.width)],'YData',[0 handles.amp],'color','blue' );

xlabel('width');
ylabel('amplitude');

set( gca, handles.l1);
set( gca, handles.l2);
set( gca, handles.l3);

%/////////////////////////////////////////////////////////////


% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%/////////////////////////////////////////////////////////////

axes(handles.axes1); 
str1_t = get ( handles.edit1, 'string');
handles.amp_t = str2double( str1_t );

str2_t = get ( handles.edit2, 'string');
handles.width_t = str2double( str2_t );

str3_t = get ( handles.edit3, 'string');
handles.freq_t = str2double( str3_t );

if(handles.amp_t<0)
   handles.amp_t=-handles.amp_t; 
end;
if(handles.width_t<0)
   handles.width_t=-handles.width_t;
end;   

set( handles.axes1, 'XLim', [-handles.width_t*2 handles.width_t*2], 'YLim', [-handles.amp_t*2 handles.amp_t*2]);


f=-handles.freq_t:.01:handles.freq_t;
y=(2*handles.amp_t*sin(2*pi*f*handles.width_t))./(2*pi*f)


%handles.p1=plot(f,y,'color','red')
plot(f,y,'color','red')
grid on;
xlabel('frequency');
ylabel('X(F)');
%set( gca, handles.p1 );

%///////////////////////////////////////////////////////////// 


% --- Executes on button press in pushbutton3.
function pushbutton3_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axes(handles.axes1); 
cla;
axes(handles.axes2); 
cla;


% --- Executes on button press in pushbutton5.
function pushbutton5_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(0,'ShowHiddenHandles','on');
delete(get(0,'children'));  




function edit3_Callback(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit3 as text
%        str2double(get(hObject,'String')) returns contents of edit3 as a double


% --- Executes during object creation, after setting all properties.
function edit3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end


