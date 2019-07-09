%
%   UIUC thesis style, adapted from report.sty
%   Spring, 1989, Dirk Grunwald & Scott Renner
%
%   Sample usage: see uiucthesis-example.tex
%
\typeout{Document Style `UIUC-Thesis'}
\typeout{Based on : Document Style `report' <16 Mar 88>.}
\input{report.sty}  % will define rep{10,11,12}.sty as well
\input{doublespace.sty}
%%
%%  doublespace.sty doesn't define these, and they're very
%%  useful.
%%
%%%%\font\tenhv  = phvb at 12pt
\def\setstretch#1{\def\baselinestretch{#1}\@normalsize}
%
\def\doublespace{\setstretch{2}}
\def\enddoublespace{}
%
\def\singlespace{\setstretch{1}}
\def\endsinglepace{}
%
\def\oneandonehalfspace{\setstretch{1.5}}
\def\endoneandonehalfspace{}

%   The size for things like Table of Contents, etc
%
\def\ThesisHeadSize{\Large}
%%!! I defined this to use throughout my thesis text
%%!! so I can change it in one place if desired
%%\def\Thesisspace{\oneandonehalfspace}
\def\Thesisspace{\doublespace}
%
% Change ``CONTENTS'' to ``TABLE OF CONTENTS''
%
\def\tableofcontents{\@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
%%!!  Kent - Fix Table of Contents - left justified, chapter size
%%!!  \fi\chapter*{{\centerline{{\ThesisHeadSize TABLE OF CONTENTS}}}%
%%!!  \@mkboth{\centerline{{\ThesisHeadSize TABLE OF CONTENTS}}}{\centerline{{\ThesisHeadSize TABLE OF CONTENTS}}}}
  \fi\chapter*{Table of Contents}
  \@mkboth{Table of Contents}{Table of Contents}%
  \@starttoc{toc}\if@restonecol\twocolumn\fi}
%
% Added 7/12/93 JEC (UIUC demands no dots for column headings (Appendix))
%
\def\l@heading#1#2{\addpenalty{-\@highpenalty}
        \addvspace{1.0em plus 1pt} \@tempdima 1.5em
        \begingroup
        \parindent \z@ \rightskip \@pnumwidth%
        \parfillskip -\@pnumwidth%
        {\bf #1}
        \hfill\mbox{}\par
        \penalty\@highpenalty \endgroup}

\addcontentsline{toc}{heading}{Chapter}
%
%   Make chapter entries in the TOC have dotted leaders.
%   Also, make certain page breaks don't occur after
%   chapter headings in the TOC.
%
\def\l@chapter#1#2{\pagebreak[3]
\vskip 1.0em plus 1pt \@tempdima 1.5em
\begingroup
\parindent \z@ \rightskip \@pnumwidth%
\indent
\parfillskip -\@pnumwidth%
\bf \leavevmode \advance\leftskip\@tempdima \hskip -\leftskip%
\hyphenpenalty10000
#1\nobreak\hfil
%
% following two lines stolen from \@dottedtocline in latex.tex
%
\nobreak\leaders\hbox{$\m@th \mkern \@dotsep mu.\mkern \@dotsep mu$}%
\hfill \nobreak \hbox to\@pnumwidth{\hfil\rm #2}\par
\endgroup\nopagebreak[4]}
%
%   Make `List of Figures' be `LIST OF FIGURES', and centered.
%%!! comment out so it is mixed case and left justified
%\def\listoffigures{\@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
% \fi\chapter*{\centerline{{\ThesisHeadSize LIST OF FIGURES}}
% \@mkboth{\centerline{{\ThesisHeadSize LIST OF FIGURES}}}{\centerline{{\ThesisHeadSize LIST OF FIGURES}}}}
% \@starttoc{lof}\if@restonecol\twocolumn
% \fi}
%
%   Make `List of Tables' be `LIST OF TABLES', and centered.
%%!! comment out so it is mixed case and left justified
%\def\listoftables{\@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
% \fi\chapter*{\centerline{{\ThesisHeadSize LIST OF TABLES}}%
% \@mkboth{\centerline{{\ThesisHeadSize LIST OF TABLES}}}{\centerline{{\ThesisHeadSize LIST OF TABLES}}}}
% \@starttoc{lot}\if@restonecol\twocolumn
% \fi}
%
%   Make `Bibliography' appear as `BIBLIOGRAPHY', and centered.
%   Add bibliography entry to TOC.
%

\def\thebibliography#1{%
%%!! Change to mixed case and left justified
%%!! \chapter*{{\ThesisHeadSize BIBLIOGRAPHY}}
%%!! \@mkboth{\centerline{{\ThesisHeadSize BIBLIOGRAPHY}}}{{\ThesisHeadSize BIBLIOGRAPHY}}
 \chapter*{References\@mkboth {References}{References}}
 \addcontentsline{toc}{chapter}{References}
%%!! \addtocontents{toc}{\protect{\addvspace{2.0ex plus 1pt}}}
%%!! \addcontentsline{toc}{chapter}{BIBLIOGRAPHY}
 \list{[\arabic{enumi}]}{\settowidth\labelwidth{[#1]}\leftmargin\labelwidth
 \advance\leftmargin\labelsep
 \usecounter{enumi}}
 \def\newblock{\hskip .11em plus .33em minus .07em}
 \sloppy\clubpenalty4000\widowpenalty4000
 \sfcode`\.=1000\relax}
\let\endthebibliography=\endlist
%
%   Normally, you would make different copies of the following
%   modifications for each point size of the intended paper,
%   however, these changes are common across all the point
%   sizes, and it's easier to keep everything in this
%   single file.
%
%
% Set the page layout for 8.5 by 11 inch pages.
%
% SIDE MARGINS:
\oddsidemargin -0.1in
\evensidemargin -0.1in
%\marginparwidth 0.95in      % might use margin paragraphs in a
%\marginparsep 0.15in        % draft version.

% VERTICAL SPACING:
%\topmargin 0.4in
%\headheight 0in
%\headsep 0.0in
%\footheight 0.5in
%\footskip 0.5in
\topmargin 0.3cm
\headheight 0in
\headsep 0.0in
%%\footheight 0.5in
\footskip 0.4in

% DIMENSION OF TEXT:
\textheight 8.9in
\textwidth 6.25in
%
% Change default section numbering depth
%
\setcounter{secnumdepth}{3}
%%
%   Modify section building to remove leading spaces & force
%   no breaks after sections start. This taken from latex.tex
%
\long\def\@sect#1#2#3#4#5#6[#7]#8{%
  \ifnum #2>\c@secnumdepth
     \def\@svsec{}
  \else
     \refstepcounter{#1}%
     \edef\@svsec{\csname the#1\endcsname\hskip 1em }\fi
     \@tempskipa #5\relax
      \ifdim \@tempskipa>\z@
        \begingroup #6\relax
         \@hangfrom%
        {\hskip #3\relax\@svsec}{\interlinepenalty\@M \ignorespaces #8\par}
        \endgroup
    \csname #1mark\endcsname{#7}%
    \addcontentsline{toc}{#1}%
       {\ifnum #2>\c@secnumdepth
        \else \protect\numberline{\csname the#1\endcsname}\fi\ignorespaces #7}%
     \else% -- ifdim
        \def\@svsechd{#6\hskip #3\@svsec%
        \ignorespaces #8\csname #1mark\endcsname
                      {\ignorespaces #7}\addcontentsline
                           {toc}{#1}{\ifnum #2>\c@secnumdepth \else
                             \protect\numberline{\csname the#1\endcsname}\fi
            \ignorespaces #7}}%
    \fi% -- ifdim
  \@xsect{#5}%
}
%%
%   Make figure and table labels be emboldened
%
\def\fnum@figure{{\large Figure \thefigure}}
\def\fnum@table{{\large Table \thetable}}
%
%   Highly penalize widows & clubs
%
\clubpenalty=100000
\widowpenalty=100000


% APPENDIX
%
% The \appendix command must do the following:
%    -- reset the chapter counter to zero
%    -- set \@chapapp to Appendix (for messages)
%    -- redefine the chapter counter to produce appendix numbers
%    -- reset the section counter to zero
%    -- redefine the \chapter command if appendix titles and headings are
%       to look different from chapter titles and headings.
%
%   UIUC style also inserts an extra APPENDIX entry into the TOC.
%   For this to work correctly, you need to put the \appendix before
%   the first appendix chapter, and you need to do it in the same file
%   as that chapter, if you're using \include. If you don't do this,
%   and you use \include, you'll see the Appendix line move past the
%   chapter in your TOC.
%
\def\@appendixtitle{Appendix}
\def\appendix{%
  \newpage
  \addcontentsline{toc}{chapter}{\@appendixtitle}
%  \addtocontents{toc}{\protect{\addvspace{2.0ex plus 1pt}}}
  \setcounter{chapter}{0}
  \setcounter{section}{0}
  \def\@chapapp{\@appendixtitle}
  \def\thechapter{\Alph{chapter}}}


%  ****************************************
%  *           COPYRIGHT PAGE             *
%  ****************************************
%
%  A copyright page (if you have one) is the first page of the thesis.
%  It is unnumbered and contains the following three lines centered
%  on the page:
%
%          (c) Copyright by
%         Author's Full Name
%                Year
%

\newcommand{\copyrightpage}{{
 \@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi\thispagestyle{empty}
 \vrule width 0pt height 1pt depth 1pt %    some non-empty space for vfil
 \vfill
 \centerline{\copyright Copyright by Kuo-Feng Ssu, 2000}
% \centerline{\@author}
% \centerline{\number\year}
 \vfill
 \if@restonecol\twocolumn \else \newpage \fi}}


%  ****************************************
%  *             TITLE PAGE               *
%  ****************************************
%
% Macros to set the degree type
%
%
\def\phdthesis{\def\@degree{Doctor of Philosophy}}
\def\msthesis{\def\@degree{Master of Science}}
\def\department#1{\def\@dept{#1}}
\def\college#1{\def\@college{#1}}
\def\schools#1{\def\@schools{#1}}
\def\degreeyear#1{\def\@degreeyear{#1}}
%
%   set initial values for title page
%
\phdthesis
\department{Computer Science}
\college{Graduate College}
\def\@schools{}
\def\@degreeyear{\number\year}
%
%   The following \maketitle should make a valid UIUC title page,
%   assuming you've set all the fields, e.g.
%       \title{MY THESIS}
%       \author{JOE X. SCHMOO}
%       \schools{B.S., Cow Flop U, 1984 \\ M.S. Illiness Tech, 1988}
%
\def\maketitle{
\begingroup
\singlespace
%
%   setting lineskip to 0pt insures no extra space between following
%   vboxes.
%
\lineskip=0pt
\lineskiplimit=\maxdimen
\thispagestyle{empty}
\setcounter{page}{0}
%
%   this bit of garbage allows us to paste a larger-than-allowed vbox
%   on the first page without getting an over-full vbox. If we don't
%   do this, we get a blank sheet of paper for the first page, followed
%   by our over-full vbox. the \vss at the bottom of this vbox causes
%   us to un-glue 9in of veritcal space, making TeX think that this
%   fits on a single page. See pages 82,83 of the TeXbook for why.
%
\vspace*{1in}%
\vtop to 0in{%
\vtop to 0in{\begin{center}\begin{tabular}{c}\uppercase\expandafter{\@title}\end{tabular}\end{center}\vss}%
%\vtop to 0in{\centerline{\uppercase\expandafter{\@title}}\vss}%
%
%   skip to ``by'' and author line; measurements w.r.t top line (2.25in)
%
\kern 1.75in%
\vtop to 0in{\centerline{BY}%
\vskip \baselineskip
\centerline{\uppercase\expandafter{\@author}}%
\vskip \baselineskip
\begin{center}\begin{tabular}{c}\@schools\end{tabular}\end{center}%
\vss}\kern -1.75in%
%
%   Skip down from last item (which has baseline at the top) to
%   thesis line.
%
\kern 4.25in%
\vtop to 0in{%
\centerline{THESIS}%
\vskip \baselineskip
%%!!\centerline{\strut Submitted in partial fulfillment of the requirements}%
%%!!\centerline{\strut for the degree of \@degree\ in \@dept}%
%%!!\centerline{\strut in the \@college\ of the}%
%%!!\centerline{\strut University of Illinois at Urbana-Champaign, \@degreeyear}%
\begin{center}\begin{tabular}{c}
Submitted in partial fulfillment of the requirements \\
for the degree of \@degree\ in \@dept \\
in the \@college\ of the \\
University of Illinois at Urbana-Champaign, \@degreeyear
\end{tabular}
\end{center}
%%!!
\vss}\kern -4.25in%
%
\kern 6.75in%
\vtop to 0in{\centerline{Urbana, Illinois}\vss}%
\kern -6.75in\vss}
\endgroup}
%
%   The following are extensions to the report style
%
%%%


%  ****************************************
%  *          PRELIMINARY PAGES           *
%  ****************************************
%
% The preliminary pages of a thesis -- abstract, dedication,
% acknowledgments, preface, table of contents, list of tables & figures &
% what-have-you -- have page numbers in roman numerals beginning with 3.
% The preface and acknowledgements use the ``default'' spacing,
% which is either double or one and one-half. All other sections use
% singlespace
%
% All of the preliminary page stuff should go inside a "preliminary"
% environment immediately preceding the general text of the thesis.
%

\def\preliminary{%
\newpage
\pagenumbering{roman}\setcounter{page}{1}
\large
\xdef\@oldbaselinestretch{\baselinestretch}
\singlespace%
}
\def\endpreliminary{%
\clearpage\pagenumbering{arabic}\setcounter{page}{1}}

% ABSTRACT:
%%
%%  NOTE: uses single spacing
%%
%
\def\abstract{
 \@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi\thispagestyle{plain} %%%%%%%%%%%%%
 \vrule width 0pt height 1pt depth 1pt %    some non-empty space for vfil
}%
\def\endabstract{\if@restonecol\twocolumn \else \newpage \fi}


% DEDICATION:
%%
%%  NOTE: uses single spacing, everything is verticaly centered
%%
%

\def\dedication{\@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
  \else \newpage \fi\thispagestyle{plain}%
 \vrule width 0pt height 1pt depth 1pt %    some non-empty space for vfil
}%
\def\enddedication{\if@restonecol\twocolumn \else \newpage \fi}

% ACKNOWLEDGEMENTS:
%
%%  NOTE: uses default spacing
%%
%
%%!! Use mixed case

\def\acknowledgmentstitle{Acknowledgments}
\def\acknowledgments{
 \@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi\thispagestyle{plain}
%%!! \setstretch{\@oldbaselinestretch}
%%!! \vrule width 0pt height 1pt depth 1pt %    some non-empty space for vfil
\chapter*{\acknowledgmentstitle}
}
\def\endacknowledgments{\vfill\if@restonecol\twocolumn \else \newpage \fi}
%
%   british-compabitibility mode
%
\let\acknowledgements=\acknowledgments
\let\endacknowledgements=\endacknowledgments

%
% preface
%%
%%  NOTE: uses default spacing
%%
%
\def\@prefacetitle{Preface}
\def\preface{
 \@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi\thispagestyle{plain}
 \setstretch{\@oldbaselinestretch}
 \vrule width 0pt height 1pt depth 1pt %    some non-empty space for vfil
}
\def\endpreface{\if@restonecol\twocolumn \else \newpage \fi}

%  *************************************
%  *          THESIS CONTENTS          *
%  *************************************
%
%   Bracket your thesis in \begin{thesis}...\end{thesis}
%
%
\def\thesis{\newpage\pagenumbering{arabic}\setcounter{page}{1}}
\def\endthesis{\newpage}

%%
%  *************************************
%  *          THESIS TRAILER           *
%  *************************************
%
% VITA:
%
\def\@vitatitle{Vita}
\def\vita{
 \@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi\thispagestyle{plain}%
 \chapter*{\@vitatitle}
 \addcontentsline{toc}{chapter}{\@vitatitle}
 \singlespace
}
\def\endvita{\if@restonecol\twocolumn \else \newpage \fi}
